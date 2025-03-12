package com.avance.cursoBasico.inyeccionDependencias;
import org.springframework.stereotype.Service;

/*
* Esta anotacion de estereotipo que implementa o da la semantica del patron de diseño facade
* para haceder ala logica del negocio como tal ejemplo de facade
* es una fachada de objectos como tal
*
* // Servicio de pagos
public class PaymentService {
    public void processPayment(String product) {
        System.out.println("Pago procesado para: " + product);
    }
}

// Servicio de inventario
public class InventoryService {
    public boolean checkStock(String product) {
        System.out.println("Verificando stock para: " + product);
        return true; // Simula que hay stock
    }
}

// Servicio de envíos
public class ShippingService {
    public void shipProduct(String product) {
        System.out.println("Producto enviado: " + product);
    }
}
    public class OrderFacade {
    private PaymentService paymentService;
    private InventoryService inventoryService;
    private ShippingService shippingService;

    public OrderFacade() {
        this.paymentService = new PaymentService();
        this.inventoryService = new InventoryService();
        this.shippingService = new ShippingService();
    }

    public void placeOrder(String product) {
        if (inventoryService.checkStock(product)) {
            paymentService.processPayment(product);
            shippingService.shipProduct(product);
            System.out.println("Orden completada para: " + product);
        } else {
            System.out.println("Stock no disponible para: " + product);
        }
    }
}

*
* */

@Service
public class ServiceStereotipe {
}
