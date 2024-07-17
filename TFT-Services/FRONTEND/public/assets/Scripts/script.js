document.addEventListener('DOMContentLoaded', () => {
    // Slider functionality
    let currentSlide = 0;
    const slides = document.querySelectorAll('.slide');
    const totalSlides = slides.length;

    if (totalSlides > 0) {
        function showSlide(index) {
            const slider = document.querySelector('.slider');
            if (slider) {
                slider.style.transform = `translateX(-${index * 100}%)`;
            }
        }

        function nextSlide() {
            currentSlide = (currentSlide + 1) % totalSlides;
            showSlide(currentSlide);
        }

        showSlide(currentSlide);
        setInterval(nextSlide, 3000); // Moves to the next slide every 3 seconds
    }

    // Navbar functionality
    const navbar = document.querySelector('.navbar');
    const navLinks = document.querySelector('.nav-links');
    const authButtons = document.querySelector('.auth-buttons');
    const cartElement = document.querySelector('.cart');

    if (navbar && navLinks && authButtons && cartElement) {
        window.addEventListener('scroll', () => {
            if (window.scrollY > 50) {
                navLinks.classList.add('hidden');
                authButtons.classList.add('hidden');
                navbar.classList.add('shrink');
                cartElement.classList.add('hidden');
            } else {
                navLinks.classList.remove('hidden');
                authButtons.classList.remove('hidden');
                navbar.classList.remove('shrink');
                cartElement.classList.remove('hidden');
            }
        });
    }

    // Yellow line animation
    const yellowLine = document.querySelector('.yellow-line');
    if (yellowLine) {
        setInterval(() => {
            yellowLine.style.transform = 'translateX(0)';
            setTimeout(() => {
                yellowLine.style.transform = 'translateX(-100%)';
            }, 500); // This matches the CSS transition duration
        }, 5000); // 5 seconds interval
    }

    // Chat form functionality
    const chatForm = document.getElementById('chat-form');
    if (chatForm) {
        chatForm.addEventListener('submit', function(event) {
            event.preventDefault();
            
            const chatEntrada = document.getElementById('chat-entrada');
            const mensaje = chatEntrada.value.trim();
            
            if (mensaje !== "") {
                const chatMensajes = document.getElementById('chat-mensajes');
                
                const nuevoMensaje = document.createElement('div');
                nuevoMensaje.textContent = mensaje;
                nuevoMensaje.className = 'mensaje';
                
                chatMensajes.appendChild(nuevoMensaje);
                
                chatEntrada.value = "";
                chatMensajes.scrollTop = chatMensajes.scrollHeight;
            }
        });
    }

    // File upload functionality
    const uploadForm = document.getElementById('upload-form');
    if (uploadForm) {
        uploadForm.addEventListener('submit', function(event) {
            event.preventDefault();
            const fileInput = document.getElementById('foto');
            const descripcion = document.getElementById('descripcion').value;

            if (fileInput.files.length > 0) {
                const file = fileInput.files[0];
                const reader = new FileReader();

                reader.onload = function(e) {
                    const chatMensajes = document.getElementById('chat-mensajes');
                    const msgDiv = document.createElement('div');
                    const img = document.createElement('img');
                    const desc = document.createElement('p');

                    img.src = e.target.result;
                    desc.textContent = descripcion;

                    msgDiv.appendChild(img);
                    msgDiv.appendChild(desc);
                    chatMensajes.appendChild(msgDiv);
                }

                reader.readAsDataURL(file);
            } else {
                alert("Por favor selecciona una foto para subir.");
            }
        });
    }

    // Evento form functionality
    document.querySelectorAll('.evento-form').forEach(form => {
        form.addEventListener('submit', function(event) {
            event.preventDefault();
            const inputs = form.querySelectorAll('input, textarea');
            let contenido = '';
            inputs.forEach(input => {
                if (input.type !== 'submit') {
                    contenido += input.value + ' ';
                }
            });

            if (contenido.trim() !== '') {
                const chatMensajes = document.getElementById('chat-mensajes');
                const msgDiv = document.createElement('div');
                msgDiv.classList.add('mensaje');
                msgDiv.textContent = contenido;
                chatMensajes.appendChild(msgDiv);

                inputs.forEach(input => {
                    if (input.type !== 'submit') {
                        input.value = '';
                    }
                });
            }
        });
    });

    // Cart functionality
    let cart = JSON.parse(localStorage.getItem('cart')) || [];

    const cartIcon = document.getElementById('cart-icon');
    const cartDropdown = document.querySelector('.cart-dropdown');
    const buyButtons = document.querySelectorAll('.buy-btn');
    const checkoutBtn = document.getElementById('checkout-btn');
    const cartTotal = document.getElementById('cart-total');
    const cartTotalContainer = document.querySelector('.cart-total');
    const checkoutContainer = document.querySelector('.checkout-btn');

    if (cartIcon) {
        cartIcon.addEventListener('click', () => {
            cartDropdown.classList.toggle('active');
            updateCartDisplay();
        });
    }

    buyButtons.forEach(button => {
        button.addEventListener('click', () => {
            const productId = button.getAttribute('data-product-id');
            addToCart(productId);
        });
    });

    window.addEventListener('storage', () => {
        cart = JSON.parse(localStorage.getItem('cart')) || [];
        updateCartDisplay();
    });

    if (checkoutBtn) {
        checkoutBtn.addEventListener('click', () => {
            alert(`Total de la compra: ${cartTotal.textContent}€`);
            localStorage.removeItem('cart');
            cart = [];
            updateCartDisplay();
            window.dispatchEvent(new Event('storage'));
        });
    }

    function addToCart(productId) {
        const product = getProductById(productId);
        if (product) {
            cart.push(product);
            localStorage.setItem('cart', JSON.stringify(cart));
            alert('Producto añadido al carrito');
            updateCartDisplay();
            window.dispatchEvent(new Event('storage'));
        }
    }

    function getProductById(id) {
        const products = [
            { id: '1', name: 'Loto Candel', price: 11.99, img: 'assets/img/loto.jpg' },
            { id: '2', name: 'Camiseta CLVT Asociado', price: 19.99, img: 'assets/img/camiseta.png' },
            { id: '3', name: 'CLVT ONE Tabla Skateboard', price: 54.99, img: 'assets/img/skate.png' },
            { id: '4', name: 'Loto Candel', price: 11.99, img: 'assets/img/loto.jpg' },
            { id: '5', name: 'Camiseta CLVT Asociado', price: 19.99, img: 'assets/img/camiseta.png' },
            { id: '6', name: 'GORRA GR Olive/Grey CLVT', price: 14.99, img: 'assets/img/gorra.png' },
            { id: '7', name: 'Producto 10', price: 45.00, img: 'producto10.jpg' },
            { id: '8', name: 'Producto 11', price: 50.00, img: 'producto11.jpg' },
            { id: '9', name: 'Producto 12', price: 55.00, img: 'producto12.jpg' },
            { id: '10', name: 'JACOPO POWER UP AGAIN DECK', price: 72.39, img: 'assets/img/baker.png' },
            { id: '11', name: 'South Park Skate Base', price: 54.95, img: 'assets/img/Kenny.png' },
            { id: '12', name: 'CASPER STACKED BLK DECK B2', price: 72.39, img: 'assets/img/baker2.png' },
            { id: '13', name: 'Foam roller /Rodillo masaje duro hard azul', price: 15.45, img: 'assets/img/rodillo.jpg' },
            { id: '14', name: 'Pistola de masaje muscular', price: 52.95, img: 'assets/img/masaje.jpg' },
        ];
        return products.find(product => product.id === id);
    }

    function updateCartDisplay() {
        const cartContainer = document.querySelector('.cart-container');
        if (!cartContainer) return;

        cartContainer.innerHTML = '';

        if (cart.length === 0) {
            cartContainer.innerHTML = '<p>El carrito está vacío.</p>';
            cartTotal.textContent = '0.00';
            cartTotalContainer.style.display = 'none';
            checkoutContainer.style.display = 'none';
            return;
        }

        let total = 0;
        cartTotalContainer.style.display = 'block';
        checkoutContainer.style.display = 'block';

        cart.forEach(item => {
            const itemDiv = document.createElement('div');
            itemDiv.className = 'cart-item';
            itemDiv.innerHTML = `
                <img src="${item.img}" alt="${item.name}">
                <h4>${item.name}</h4>
                Precio: ${item.price}€
                Eliminar
                `;
                cartContainer.appendChild(itemDiv);
                total += item.price;
                });
                cartTotal.textContent = total.toFixed(2);

                document.querySelectorAll('.remove-btn').forEach(button => {
                    button.addEventListener('click', (e) => {
                        const productId = e.target.getAttribute('data-product-id');
                        removeFromCart(productId);
                    });
                });
            }
            
            function removeFromCart(productId) {
                cart = cart.filter(item => item.id !== productId);
                localStorage.setItem('cart', JSON.stringify(cart));
                updateCartDisplay();
                window.dispatchEvent(new Event('storage'));
            }
            
            updateCartDisplay();  // Update the cart display on page load
        });