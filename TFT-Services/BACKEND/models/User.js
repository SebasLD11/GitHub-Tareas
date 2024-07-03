const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const UserSchema = new Schema({
    username: { type: String, required: true, unique: true },
    password: { type: String, required: true },
    email: { type: String, required: true, unique: true },
    role: { type: String, default: 'user', required: true }  // Asegúrate de que el rol tiene un valor predeterminado
});

module.exports = mongoose.model('User', UserSchema);
