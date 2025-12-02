package com.levelup.gamer.config;

import com.levelup.gamer.model.Product;
import com.levelup.gamer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Solo cargar productos si la tabla está vacía
        if (productRepository.count() == 0) {
            System.out.println("🎮 Iniciando carga de productos...");
            loadProducts();
            System.out.println("✅ Productos cargados exitosamente: " + productRepository.count());
        } else {
            System.out.println("ℹ️  Base de datos ya contiene " + productRepository.count() + " productos");
        }
    }
    
    private void loadProducts() {
        List<Product> products = Arrays.asList(
            createProduct("playstation-5", "PlayStation 5", "Consolas", 549990.0, "/img/ps5-5.png.jpg",
                "Gráficos 4K, ray tracing y el nuevo DualSense para una experiencia inmersiva.",
                "La PlayStation 5 ofrece tiempos de carga ultrarrápidos, gráficos ray-tracing y soporte 4K, además de un catálogo exclusivo que sigue creciendo.",
                Arrays.asList("CPU AMD Zen 2 de 8 núcleos a 3.5 GHz", "GPU RDNA 2 con 10.28 TFLOPs y Ray Tracing", "Unidad SSD ultra rápida de 825 GB", "Salida de video hasta 4K a 120 FPS", "Retrocompatibilidad con PS4"),
                Arrays.asList("1 consola PlayStation 5", "1 control DualSense blanco", "Cable HDMI 2.1 y alimentación", "Astro's Playroom preinstalado"),
                Arrays.asList("pc-gamer-asus-rog", "xbox-series-s", "teclado-kurama"), 10),
            
            createProduct("pc-gamer-asus-rog", "PC Gamer ASUS ROG Strix", "Computadores Gamers", 1299990.0, "/img/ROG-Strix-G16.jpg",
                "Portátil gamer con GPU NVIDIA RTX y pantalla de 165 Hz.",
                "La serie ROG Strix de ASUS combina portabilidad y potencia con gráficas NVIDIA RTX y procesadores Intel de última generación.",
                Arrays.asList("Intel Core i7 de 13ª generación", "GPU NVIDIA GeForce RTX 4060 8GB", "16 GB RAM DDR5 ampliable", "SSD NVMe de 1 TB", "Pantalla 16\" QHD 165 Hz"),
                Arrays.asList("Cargador oficial de 240 W", "Mouse gamer ASUS", "Licencia Windows 11 Home"),
                Arrays.asList("playstation-5", "monitor-aoc-curvo", "silla-secretlab"), 5),
            
            createProduct("silla-secretlab", "Silla Gamer Secretlab Titan", "Sillas Gamers", 349990.0, "/img/1689194af682e4a6eba3e59a9fcd074c.png",
                "Silla profesional con espuma fría y soporte lumbar ajustable.",
                "Secretlab Titan está pensada para sesiones intensas con soporte lumbar integrado, reclinación 165° y materiales premium resistentes.",
                Arrays.asList("Reclinación hasta 165° con bloqueo", "Pistón de clase 4 certificado", "Espuma fría moldeada", "Soporte lumbar ajustable 4D", "Capacidad hasta 130 kg"),
                Arrays.asList("Cojín magnético para cabeza", "Kit de armado", "Garantía 3 años"),
                Arrays.asList("playstation-5", "xbox-series-s", "pc-gamer-asus-rog"), 8),
            
            createProduct("mouse-logitech-g502", "Mouse Logitech G502 HERO", "Mouse", 49990.0, "/img/MouseLogitech.png.jpg",
                "Sensor HERO 25K y 11 botones programables para máxima precisión.",
                "El Logitech G502 HERO es uno de los mouse más populares gracias a su sensor HERO 25K, pesos ajustables y software G HUB.",
                Arrays.asList("Sensor HERO 25K con 25 600 DPI", "11 botones programables", "Pesos ajustables incluidos", "Sistema LIGHTSYNC RGB", "Cable trenzado resistente"),
                Arrays.asList("Set de pesos ajustables", "Manual rápido", "Garantía 2 años"),
                Arrays.asList("mousepad-razer-goliathus", "teclado-kurama", "auriculares-hyperx"), 20),
            
            createProduct("auriculares-hyperx", "Auriculares HyperX Cloud II", "Accesorios", 79990.0, "/img/Proyecto Quitar fondo.png.jpg",
                "Sonido 7.1 virtual, micrófono desmontable y almohadillas memory foam.",
                "HyperX Cloud II es el estándar de la comunidad gamer: fabricado en aluminio, sonido envolvente y gran comodidad para largas sesiones.",
                Arrays.asList("Sonido 7.1 virtual con control USB", "Drivers de 53 mm", "Micrófono desmontable con cancelación", "Estructura de aluminio resistente", "Compatibles con PC, PlayStation y Xbox"),
                Arrays.asList("Control de audio USB", "Set de almohadillas extra", "Bolsa de transporte"),
                Arrays.asList("mouse-logitech-g502", "mousepad-razer-goliathus", "playstation-5"), 15),
            
            createProduct("xbox-series-s", "Xbox Series S", "Consolas", 310000.0, "/img/61QKAlzPSfL._UF1000,1000_QL80_.png",
                "Consola next-gen totalmente digital con 512 GB SSD.",
                "Xbox Series S es la consola más compacta y silenciosa de Microsoft, perfecta para Game Pass y juegos en 1440p a 120 FPS.",
                Arrays.asList("CPU AMD Zen 2 de 8 núcleos", "GPU RDNA 2 con 4 TFLOPs", "512 GB SSD NVMe", "Salida 1440p hasta 120 FPS", "Soporte Dolby Atmos y Dolby Vision"),
                Arrays.asList("Control inalámbrico Xbox Series blanco", "Cable HDMI de ultra velocidad", "Prueba Game Pass Ultimate (14 días)"),
                Arrays.asList("playstation-5", "control-xbox-series-x", "monitor-aoc-curvo"), 12),
            
            createProduct("teclado-kurama", "Teclado Mecánico Kurama", "Teclado", 44000.0, "/img/71FSIp+tDNL._AC_SL1500_.png.jpg",
                "Switches red, iluminación RGB y estructura metálica.",
                "Kurama combina switches lineales red con iluminación RGB y placa metálica para brindar respuesta y durabilidad.",
                Arrays.asList("Switches mecánicos red lineales", "Iluminación RGB direccionable", "Cable USB desmontable", "Construcción metálica", "Incluye software de macros"),
                Arrays.asList("Extractor de keycaps", "Keycaps extra", "Manual en español"),
                Arrays.asList("mouse-logitech-g502", "mousepad-razer-goliathus", "pc-gamer-asus-rog"), 18),
            
            createProduct("monitor-aoc-curvo", "Monitor AOC Curvo 27\" 180 Hz", "Monitores", 180000.0, "/img/shopping.png",
                "Panel VA curvo 1500R con 1 ms de respuesta y FreeSync.",
                "El monitor curvo AOC 27\" entrega inmersión total gracias a su curvatura 1500R, tasa de refresco 180 Hz y 1 ms MPRT.",
                Arrays.asList("Resolución 1920 x 1080 Full HD", "Tasa de refresco 180 Hz", "1 ms MPRT", "Tecnología AMD FreeSync Premium", "Soporte ajustable en inclinación"),
                Arrays.asList("Cable DisplayPort", "Cable HDMI", "Kit de montaje VESA"),
                Arrays.asList("pc-gamer-asus-rog", "xbox-series-s", "mouse-logitech-g502"), 7),
            
            createProduct("mousepad-razer-goliathus", "Mousepad Razer Goliathus Extended", "Mousepad", 29990.0, "/img/Mousepad.png.jpg",
                "Superficie optimizada para control y velocidad con base antideslizante.",
                "Razer Goliathus Extended cubre teclado y mouse con superficie texturizada para control preciso y base de goma anti deslizante.",
                Arrays.asList("Dimensiones 920 x 294 mm", "Base de goma antideslizante", "Superficie microtexturizada", "Bordes cosidos para mayor durabilidad", "Compatible con sensores ópticos y láser"),
                Arrays.asList("Bolsa de transporte reutilizable"),
                Arrays.asList("mouse-logitech-g502", "teclado-kurama", "pc-gamer-asus-rog"), 25),
            
            createProduct("polera-level-up", "Polera Gamer 'Level-Up'", "Poleras Personalizadas", 14990.0, "/img/polera_gamer_life.png.jpg",
                "Algodón premium con estampado glow in the dark edición Level-Up.",
                "Nuestra polera Level-Up está confeccionada en algodón premium 100% y cuenta con estampado glow in the dark para destacar en eventos LAN.",
                Arrays.asList("Algodón 100% 200 g/m²", "Estampado glow in the dark", "Corte unisex", "Disponible de S a XXL", "Lavado apto en lavadora"),
                Arrays.asList("Packaging coleccionable Level-Up"),
                Arrays.asList("mousepad-razer-goliathus", "auriculares-hyperx", "silla-secretlab"), 30),
            
            createProduct("control-xbox-series-x", "Control Xbox Series X", "Accesorios", 59990.0, "/img/19311564-964f-4c51-ae32-cd1f4a31e006.png.jpg",
                "Control oficial con agarre texturizado y botón Share dedicado.",
                "El control inalámbrico Xbox Series incorpora texturas antideslizantes, gatillos híbridos y botón Share para capturar clips al instante.",
                Arrays.asList("Reconexión rápida con Bluetooth LE", "Puerto USB-C y jack 3.5 mm", "Agarre antideslizante en gatillos", "Compatibilidad multiplataforma", "Hasta 40 horas de autonomía"),
                Arrays.asList("Cable USB-C", "Pilas AA (2)"),
                Arrays.asList("xbox-series-s", "playstation-5", "auriculares-hyperx"), 14),
            
            createProduct("carcassonne", "Carcassonne", "Juegos de Mesa", 24990.0, "/img/juegodemesa.jpg",
                "Juego de colocación de losetas para toda la familia. Versión en español.",
                "Carcassonne es un clásico de táctica y construcción de caminos donde cada partida es diferente. Ideal para 2 a 5 jugadores.",
                Arrays.asList("Edad recomendada: 7+", "Duración: 35 minutos aprox.", "Incluye expansión del río", "Versión en español Latinoamérica", "Componentes de cartón reforzado"),
                Arrays.asList("72 losetas de territorio", "5 meeples por jugador", "Tablero marcador de puntos"),
                Arrays.asList("catan", "polera-level-up", "playstation-5"), 10),
            
            createProduct("catan", "Catan", "Juegos de Mesa", 34990.0, "/img/Adobe Express - file.png.jpg",
                "El juego de comercio y construcción más premiado del mundo.",
                "Catan enfrenta a los jugadores a colonizar una isla mediante comercio, estrategia y construcción. Perfecto para noches de juego.",
                Arrays.asList("Edad recomendada: 10+", "Duración: 75 minutos aprox.", "3 a 4 jugadores", "Edición en español", "Incluye dados personalizados"),
                Arrays.asList("19 hexágonos de terreno", "95 cartas de recursos", "4 tableros de puntos"),
                Arrays.asList("carcassonne", "polera-level-up", "xbox-series-s"), 8)
        );
        
        productRepository.saveAll(products);
    }
    
    private Product createProduct(String slug, String nombre, String categoria, Double precio, 
                                   String imagen, String resumen, String descripcion,
                                   List<String> specs, List<String> incluye, 
                                   List<String> relacionados, Integer stock) {
        Product product = new Product();
        product.setSlug(slug);
        product.setNombre(nombre);
        product.setCategoria(categoria);
        product.setPrecio(precio);
        product.setImagen(imagen);
        product.setResumen(resumen);
        product.setDescripcion(descripcion);
        product.setSpecs(String.join("|", specs));
        product.setIncluye(String.join("|", incluye));
        product.setRelacionados(String.join(",", relacionados));
        product.setStock(stock);
        return product;
    }
}
