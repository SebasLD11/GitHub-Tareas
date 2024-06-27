const express = require('express');
const router = express.Router();
const User = require('../models/user');
const auth = require('../middleware/auth');
const verifyRole = require('../middleware/role');

// Obtener perfil de usuario autenticado
router.get('/profile', auth, async (req, res) => {
    try {
        const user = await User.findById(req.user.id).select('-password');
        res.json(user);
    } catch (err) {
        res.status(500).json({ message: 'Error fetching user profile' });
    }
});

// Obtener todos los usuarios (solo administrador)
router.get('/', auth, verifyRole('admin'), async (req, res) => {
    try {
        const users = await User.find().select('-password');
        res.json(users);
    } catch (err) {
        res.status(500).json({ message: 'Error fetching users' });
    }
});

module.exports = router;
