const User = require('../models/User');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');

// Función para actualizar el perfil del usuario
exports.updateUserProfile = async (req, res) => {
    const { username, email, password } = req.body;
    const userId = req.user._id;

    try {
        // Buscar el usuario por su ID
        const user = await User.findById(userId);
        if (!user) {
            return res.status(404).json({ message: 'User not found' });
        }

        // Actualizar los campos del perfil
        if (username) user.username = username;
        if (email) user.email = email;
        if (password) user.password = bcrypt.hashSync(password, 10);

        await user.save();

        res.json({ message: 'Profile updated successfully', user });
    } catch (err) {
        res.status(500).json({ message: 'Error updating profile', error: err.message });
    }
};
