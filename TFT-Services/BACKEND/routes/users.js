const express = require('express');
const router = express.Router();
const auth = require('../middleware/auth');
const User = require('../models/User');
const { updateUserProfile } = require('../controllers/userController');

// Obtener perfil del usuario autenticado
router.get('/me', auth, async (req, res) => {
    try {
        const user = await User.findById(req.user._id).select('-password');
        res.json(user);
    } catch (err) {
        res.status(500).json({ message: 'Error fetching user profile', error: err.message });
    }
});
// Ruta para actualizar el perfil del usuario autenticado
router.put('/profile', auth, updateUserProfile);

module.exports = router;
