function createCart() {
    fetch('/cart/create', { method: 'POST' })
        .then(response => response.text())
        .then(cartId => alert(`Cart created with ID: ${cartId}`));
}

function getCart() {
    const cartId = document.getElementById('cartId').value;
    fetch(`/cart/get/${cartId}`)
        .then(response => response.json())
        .then(cart => alert(JSON.stringify(cart)));
}

function addProductToCart() {
    const cartId = document.getElementById('cartId').value;
    const productId = parseInt(document.getElementById('productId').value);
    const productName = document.getElementById('productName').value;
    const productAmount = parseFloat(document.getElementById('productAmount').value);

    const product = {
        id: productId,
        description: productName,
        amount: productAmount
    };

    fetch(`/cart/add/${cartId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product)
    }).then(() => alert('Product added to cart'));
}

function deleteCart() {
    const cartId = document.getElementById('deleteCartId').value;
    fetch(`/cart/delete/${cartId}`, { method: 'DELETE' })
        .then(() => alert(`Cart with ID ${cartId} deleted`));
}
