package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
    }

    @Test
    void testCreateAndFindById() {
        Product product = new Product();
        product.setProductId("1");
        product.setProductName("Sabun");
        product.setProductQuantity(10);

        productRepository.create(product);

        Product found = productRepository.findById("1");
        assertNotNull(found);
        assertEquals("Sabun", found.getProductName());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> iterator = productRepository.findAll();
        assertFalse(iterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product p1 = new Product();
        p1.setProductId("1");

        Product p2 = new Product();
        p2.setProductId("2");

        productRepository.create(p1);
        productRepository.create(p2);

        Iterator<Product> iterator = productRepository.findAll();

        assertTrue(iterator.hasNext());
        assertEquals("1", iterator.next().getProductId());
        assertEquals("2", iterator.next().getProductId());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product();
        product.setProductId("1");
        product.setProductName("Lama");

        productRepository.create(product);

        product.setProductName("Baru");
        productRepository.update(product);

        Product updated = productRepository.findById("1");
        assertEquals("Baru", updated.getProductName());
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product();
        product.setProductId("1");

        productRepository.create(product);
        productRepository.delete("1");

        assertNull(productRepository.findById("1"));
    }
}