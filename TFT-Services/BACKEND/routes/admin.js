const express = require('express');
const router = express.Router();
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const User = require('../models/User');
const auth = require('../middleware/auth');
const verifyRole = require('../middleware/role');
require('dotenv').config();

// Registrar administrador (solo accesible para administradores)
router.post('/register-admin', auth, verifyRole('admin'), async (req, res) => {
    const { username, email, password } = req.body;
    try {
        const user = new User({
            username,
            email,
            password: bcrypt.hashSync(password, 10),
            role: 'admin'
        });
        await user.save();
        res.status(201).json({ message: 'Admin registered successfully' });
    } catch (err) {
        res.status(500).json({ message: 'Error registering admin', error: err.message });
    }
});

module.exports = router;
