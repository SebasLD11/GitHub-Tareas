const mongoose = require('mongoose');
const bcrypt = require('bcryptjs');
const User = require('./models/User'); // Asegúrate de que la ruta al modelo de usuario es correcta

// Conectar a la base de datos
mongoose.connect('mongodb://localhost:27017/tftservices')
.then(async () => {
    console.log('MongoDB connected');

    // Cambia el correo electrónico y la contraseña a los del usuario administrador
    const adminEmail = 'admin@example.com';
    const adminPassword = 'adminpassword';

    // Busca el usuario administrador por correo electrónico
    const adminUser = await User.findOne({ email: adminEmail });

    if (adminUser) {
        adminUser.role = 'admin';
        await adminUser.save();
        console.log('Admin user updated');
    } else {
        // Crear el usuario administrador
        const hashedPassword = await bcrypt.hash(adminPassword, 10);
        const newAdminUser = new User({
            username: 'admin',
            email: adminEmail,
            password: hashedPassword,
            role: 'admin'
        });

        await newAdminUser.save();
        console.log('Admin user created');
    }

    mongoose.disconnect();
})
.catch(err => {
    console.error(err);
});
