const jwt = require('jsonwebtoken');

function generateToken(user) {
    return jwt.sign({ id: user._id, role: user.role }, process.env.SECRET_KEY, { expiresIn: '1h' });
}

module.exports = generateToken;
