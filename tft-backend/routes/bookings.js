const express = require('express');
const router = express.Router();
const auth = require('../middleware/auth');
const Booking = require('../models/Booking');
const Service = require('../models/Service');
const User = require('../models/User');

// Obtener todas las reservas
router.get('/', auth, async (req, res) => {
    try {
        const bookings = await Booking.find().populate('user').populate('service');
        res.json(bookings);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

// Obtener reservas de un usuario específico
router.get('/user/:userId', auth, async (req, res) => {
    try {
        const bookings = await Booking.find({ user: req.params.userId }).populate('service');
        res.json(bookings);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

// Crear una nueva reserva
router.post('/', auth, async (req, res) => {
    const { service, date, timeSlot } = req.body;

    // Verifica si el servicio existe
    const existingService = await Service.findById(service);
    if (!existingService) {
        return res.status(404).json({ message: 'Service not found' });
    }

    // Verifica si el usuario existe
    const existingUser = await User.findById(req.user.id);
    if (!existingUser) {
        return res.status(404).json({ message: 'User not found' });
    }

    const booking = new Booking({
        user: req.user.id,
        service,
        date,
        timeSlot
    });

    try {
        const newBooking = await booking.save();
        res.status(201).json(newBooking);
    } catch (err) {
        res.status(400).json({ message: err.message });
    }
});

// Eliminar una reserva
router.delete('/:id', auth, async (req, res) => {
    try {
        const booking = await Booking.findById(req.params.id);

        if (!booking) {
            return res.status(404).json({ message: 'Booking not found' });
        }

        if (booking.user.toString() !== req.user.id) {
            return res.status(401).json({ message: 'User not authorized' });
        }

        await booking.remove();
        res.json({ message: 'Booking removed' });
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

module.exports = router;
