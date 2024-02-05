function createCart() {
    fetch('/cart/create', { method: 'POST' })
        .then(response => response.text())
        .then(cartId => alert(`Cart created with ID: ${cartId}`))
        .catch(error => console.error('Error creating cart:', error));
}

function getCart() {
    const cartId = document.getElementById('cartId').value;

    if (!cartId) {
        alert('Fill it with a valid cart ID.');
        return;
    }
    fetch(`/cart/get/${cartId}`)
        .then(response => response.json())
        .then(cart => alert(JSON.stringify(cart)))
        .catch(error => console.error('Error getting cart:', error));
}

function addProductToCart() {
    const cartId = document.getElementById('cartId').value;
    const productId = parseInt(document.getElementById('productId').value);
    const productDescription = document.getElementById('productDescription').value;
    const productAmount = parseFloat(document.getElementById('productAmount').value);

    const product = {
        id: productId,
        description: productDescription,
        amount: productAmount
    };

    if (!productId || !productDescription || !productAmount) {
        alert('Fill all fields, please.');
        return;
    }

    fetch(`/cart/add/${cartId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product)
    }).then(() => alert('Product added to cart'))
        .catch(error => console.error('Error adding product:', error));
}

function deleteCart() {
    const cartId = document.getElementById('deleteCartId').value;

    if(!cartId){
        alert('Nonexistent ID to delete');
        return;
    }
// Realizar una solicitud para verificar si el carrito existe antes de intentar eliminarlo
    fetch(`/cart/get/${cartId}`)
        .then(response => {
            if (!response.ok) {
                if (response.status === 404) {
                    alert('No se encontró el carrito. Verifique el ID del carrito.');
                } else {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
            }
            // Si el carrito existe, proceder con la eliminación
            return fetch(`/cart/delete/${cartId}`, { method: 'DELETE' });
        })
        .then(response => {
            if (response.ok) {
                alert(`Carrito con ID ${cartId} eliminado exitosamente.`);
            } else {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
        })
        .catch(error => console.error('Error deleting cart:', error));
}
