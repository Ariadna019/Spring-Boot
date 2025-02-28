package com.mtw.logeoregistrar.Services;

import com.mtw.logeoregistrar.Models.Cart;
import com.mtw.logeoregistrar.Models.Producto;
import com.mtw.logeoregistrar.Repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    // Método para agregar un producto al carrito
    public void agregarProducto(Producto producto) {
        Cart cartItem = new Cart();
        cartItem.setProducto(producto);
        cartItem.setCantidad(1); // Establecer cantidad inicial
        cartRepository.save(cartItem);
    }

    // Método para obtener todos los artículos del carrito
    public List<Cart> getProductos() {
        return cartRepository.findAll();
    }

    // Método para eliminar un producto del carrito
    public void eliminarProducto(Long id) {
        cartRepository.deleteById(id);
    }

    // Método para realizar el pago (puedes implementar la lógica que necesites)
    public void realizarPago() {
        // Lógica para procesar el pago
        cartRepository.deleteAll(); // Vaciar el carrito después del pago
    }
}