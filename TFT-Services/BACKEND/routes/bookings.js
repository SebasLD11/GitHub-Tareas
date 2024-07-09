const express = require('express');
const router = express.Router();
const mongoose = require('mongoose');
const auth = require('../middleware/auth');
const verifyRole = require('../middleware/role');
const Booking = require('../models/Booking');
const Service = require('../models/Service');  // Asegúrate de importar el modelo de servicio

// Crear reserva (autenticado)
router.post('/', auth, async (req, res) => {
    const { service, date, timeSlot } = req.body;
    console.log('Received booking request:', { service, date, timeSlot });
    console.log('User ID:', req.user._id);

    try {
        // Verificar que el ID del servicio es un ObjectId válido
        if (!mongoose.Types.ObjectId.isValid(service)) {
            console.log('Invalid service ID:', service);
            return res.status(400).json({ message: 'Invalid service ID' });
        }

        // Verificar que el servicio existe
        const serviceExists = await Service.findById(service);
        if (!serviceExists) {
            return res.status(404).json({ message: 'Service not found' });
        }

        const booking = new Booking({ user: req.user._id, service, date, timeSlot });
        await booking.save();
        res.status(201).json({ message: 'Booking created successfully', booking });
    } catch (err) {
        console.error('Error creating booking:', err);
        res.status(500).json({ message: 'Error creating booking', error: err.message });
    }
});

// Obtener todas las reservas (solo administrador)
router.get('/', auth, verifyRole('admin'), async (req, res) => {
    try {
        const bookings = await Booking.find().populate('user').populate('service');
        res.json(bookings);
    } catch (err) {
        res.status(500).json({ message: 'Error fetching bookings', error: err.message });
    }
});

// Obtener todas las reservas de un usuario específico (autenticado)
router.get('/user/:userId', auth, async (req, res) => {
    try {
        if (req.user._id.toString() !== req.params.userId && req.user.role !== 'admin') {
            return res.status(403).json({ message: 'Access denied' });
        }

        const bookings = await Booking.find({ user: req.params.userId }).populate('service');
        res.json(bookings);
    } catch (err) {
        res.status(500).json({ message: 'Error fetching user bookings', error: err.message });
    }
});
// Obtener detalles de una reserva específica (autenticado)
router.get('/:bookingId', auth, async (req, res) => {
    try {
        const booking = await Booking.findById(req.params.bookingId).populate('user').populate('service');
        if (!booking) {
            return res.status(404).json({ message: 'Booking not found' });
        }
        if (req.user._id.toString() !== booking.user._id.toString() && req.user.role !== 'admin') {
            return res.status(403).json({ message: 'Access denied' });
        }
        res.json(booking);
    } catch (err) {
        res.status(500).json({ message: 'Error fetching booking details', error: err.message });
    }
});

// Actualizar una reserva específica (autenticado)
router.put('/:bookingId', auth, async (req, res) => {
    const { date, timeSlot } = req.body;
    console.log('Updating booking:', { bookingId: req.params.bookingId, date, timeSlot });

    try {
        const booking = await Booking.findById(req.params.bookingId);
        if (!booking) {
            return res.status(404).json({ message: 'Booking not found' });
        }
        if (req.user._id.toString() !== booking.user._id.toString() && req.user.role !== 'admin') {
            return res.status(403).json({ message: 'Access denied' });
        }

		   // Actualizar los campos de la reserva
		        if (date) booking.date = date;
		        if (timeSlot) booking.timeSlot = timeSlot;

		        await booking.save();

		   // Obtener la información del servicio
		        const service = await Service.findById(booking.service);

		   // Enviar la respuesta con la información de la reserva actualizada y el servicio
		        res.json({
		            message: 'Booking updated successfully',
		            booking: {
		                _id: booking._id,
		                date: booking.date,
		                timeSlot: booking.timeSlot,
		                service: {
		                    name: service.name
		                }
		            }
		        });
		  } catch (err) {
		        console.error('Error updating booking:', err);
		        res.status(500).json({ message: 'Error updating booking', error: err.message });
		    }
		});

// Eliminar una reserva específica (autenticado)
router.delete('/:bookingId', auth, async (req, res) => {
    try {
        const booking = await Booking.findById(req.params.bookingId);
        if (!booking) {
            return res.status(404).json({ message: 'Booking not found' });
        }

        await Booking.deleteOne({ _id: req.params.bookingId });
        res.json({ message: 'Booking deleted successfully' });
    } catch (err) {
        console.error('Error deleting booking:', err);
        res.status(500).json({ message: 'Error deleting booking', error: err.message });
    }
});
module.exports = router;
