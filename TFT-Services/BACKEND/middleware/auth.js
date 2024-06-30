const jwt = require('jsonwebtoken');
const User = require('../models/User');

const auth = async (req, res, next) => {
    const token = req.header('Authorization') && req.header('Authorization').replace('Bearer ', '');
    console.log('Received Token:', token);
    if (!token) {
        return res.status(401).json({ message: 'No token, authorization denied' });
    }

    try {
        const secretKey = process.env.SECRET_KEY;
        console.log('Secret Key:', secretKey);
        const decoded = jwt.verify(token, secretKey);
        console.log('Decoded Token:', decoded);
        req.user = await User.findById(decoded.id).select('-password');
        console.log('Authenticated User:', req.user);
        if (!req.user) {
            return res.status(401).json({ message: 'User not found' });
        }
        next();
    } catch (err) {
        console.error('Error verifying token:', err);
        res.status(401).json({ message: 'Token is not valid' });
    }
};

module.exports = auth;
