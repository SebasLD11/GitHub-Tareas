const User = require('../models/User');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
require('dotenv').config();  // Asegúrate de cargar dotenv

// Registrar usuario
exports.register = async (req, res) => {
    const { username, email, password, role } = req.body;
    try {
        const user = new User({ username, email, password: bcrypt.hashSync(password, 10) });
        await user.save();
        res.status(201).json({ message: 'User registered successfully' });
    } catch (err) {
        res.status(500).json({ message: 'Error registering user', error: err.message });
    }
};

// Iniciar sesión de usuario
exports.login = async (req, res) => {
    const { email, password } = req.body;
    try {
        const user = await User.findOne({ email });
        if (user && bcrypt.compareSync(password, user.password)) {
            const token = jwt.sign({ id: user._id, role: user.role }, process.env.SECRET_KEY, { expiresIn: '1h' });
            res.json({ token });
        } else {
            res.status(401).json({ message: 'Invalid credentials' });
        }
    } catch (err) {
        res.status(500).json({ message: 'Error logging in user', error: err.message });
    }
};