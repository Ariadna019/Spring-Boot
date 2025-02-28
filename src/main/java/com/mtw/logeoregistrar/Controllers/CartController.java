package com.mtw.logeoregistrar.Controllers;

import com.mtw.logeoregistrar.Models.Cart;
import com.mtw.logeoregistrar.Models.Producto;
import com.mtw.logeoregistrar.Services.CartService;
import com.mtw.logeoregistrar.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductoService productoService;

    @GetMapping("/Cart")
    public String showCart(Model model) {
        List<Cart> cartItems = cartService.getProductos();
        model.addAttribute("cartItems", cartItems);
        return "Cart"; // Retorna la vista Cart.html
    }

    @PostMapping("/agregarProducto")
    public String agregarProducto(@RequestParam("productoId") Integer productoId) {
        Producto producto = productoService.obtenerPorId(productoId).orElse(null);
        if (producto != null) {
            cartService.agregarProducto(producto);
        }
        return "redirect:/Cart?success=true"; // Redirige al carrito
    }

    @PostMapping("/eliminarProducto")
    public String eliminarProducto(@RequestParam("itemId") Long itemId) {
        cartService.eliminarProducto(itemId);
        return "redirect:/Cart"; // Redirige al carrito
    }

    @PostMapping("/pagar")
    public String pagar() {
        cartService.realizarPago();
        return "redirect:/"; // Redirige a la página principal
    }
}