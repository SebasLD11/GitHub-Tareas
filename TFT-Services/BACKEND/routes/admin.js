const express = require('express');
const router = express.Router();
const auth = require('../middleware/auth'); // Importar middleware de autenticación
const verifyRole = require('../middleware/role'); // Importar middleware de roles
const User = require('../models/User');
const Service = require('../models/Service');
const Booking = require('../models/Booking');

// Obtener todos los usuarios (solo administrador)
router.get('/users', auth, verifyRole('admin'), async (req, res) => {
    try {
        const users = await User.find();
        res.json(users);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

// Eliminar un usuario (solo administrador)
router.delete('/users/:id', auth, verifyRole('admin'), async (req, res) => {
    try {
        const user = await User.findById(req.params.id);

        if (!user) {
            return res.status(404).json({ message: 'User not found' });
        }

        await user.remove();
        res.json({ message: 'User removed' });
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

// Obtener todos los servicios (solo administrador)
router.get('/services', auth, verifyRole('admin'), async (req, res) => {
    try {
        const services = await Service.find();
        res.json(services);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

// Eliminar un servicio (solo administrador)
router.delete('/services/:id', auth, verifyRole('admin'), async (req, res) => {
    try {
        const service = await Service.findById(req.params.id);

        if (!service) {
            return res.status(404).json({ message: 'Service not found' });
        }

        await service.remove();
        res.json({ message: 'Service removed' });
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

// Obtener todas las reservas (solo administrador)
router.get('/bookings', auth, verifyRole('admin'), async (req, res) => {
    try {
        const bookings = await Booking.find().populate('user').populate('service');
        res.json(bookings);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

// Eliminar una reserva (solo administrador)
router.delete('/bookings/:id', auth, verifyRole('admin'), async (req, res) => {
    try {
        const booking = await Booking.findById(req.params.id);

        if (!booking) {
            return res.status(404).json({ message: 'Booking not found' });
        }

        await booking.remove();
        res.json({ message: 'Booking removed' });
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

module.exports = router;
