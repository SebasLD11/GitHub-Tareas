const jwt = require('jsonwebtoken');

const generateToken = (id, role) => {
    return jwt.sign({ id, role }, process.env.SECRET_KEY, { expiresIn: '1h' });
};

module.exports = generateToken;
