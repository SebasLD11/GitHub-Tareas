const express = require('express');
const router = express.Router();
const auth = require('../middleware/auth');
const Booking = require('../models/Booking');
const Service = require('../models/Service');
const User = require('../models/User');

// Get all bookings
router.get('/', auth, async (req, res) => {
    try {
        const bookings = await Booking.find().populate('user').populate('service');
        res.json(bookings);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

// Get bookings for a specific user
router.get('/user/:userId', auth, async (req, res) => {
    try {
        const bookings = await Booking.find({ user: req.params.userId }).populate('service');
        res.json(bookings);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

// Create a new booking
router.post('/', auth, async (req, res) => {
    const { service, date, timeSlot } = req.body;

    // Check if the service exists
    const existingService = await Service.findById(service);
    if (!existingService) {
        return res.status(404).json({ message: 'Service not found' });
    }

    // Check if the user exists
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

// Delete a booking
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
