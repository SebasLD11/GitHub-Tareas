const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const BookingSchema = new Schema({
    user: { type: Schema.Types.ObjectId, ref: 'User', required: true },
    service: { type: Schema.Types.ObjectId, ref: 'Service', required: true },
    date: { type: Date, required: true },
    timeSlot: { type: String, required: true }
});

module.exports = mongoose.model('Booking', BookingSchema);
