const express = require('express');
const router = express.Router();
const auth = require('../middleware/auth');
const verifyRole = require('../middleware/role');
const Booking = require('../models/Booking');

// Crear reserva (autenticado)
router.post('/', auth, async (req, res) => {
    const { service, date, timeSlot } = req.body;
    try {
        const booking = new Booking({ user: req.user.id, service, date, timeSlot });
        await booking.save();
        res.status(201).json({ message: 'Booking created successfully' });
    } catch (err) {
        res.status(500).json({ message: 'Error creating booking', error: err.message });
    }
});

// Obtener todas las reservas (solo administrador)
router.get('/', auth, verifyRole('admin'), async (req, res) => {
    try {
        const bookings = await Booking.find().populate('user service');
        res.json(bookings);
    } catch (err) {
        res.status(500).json({ message: 'Error fetching bookings', error: err.message });
    }
});

module.exports = router;
