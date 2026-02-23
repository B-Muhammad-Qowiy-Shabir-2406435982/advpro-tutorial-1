package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductRepository repository;
    private ProductServiceImpl service;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(ProductRepository.class);
        service = new ProductServiceImpl();

        ReflectionTestUtils.setField(
                service,
                "productRepository",
                repository
        );
    }

    @Test
    void testCreate() {
        Product product = new Product();
        Product result = service.create(product);

        assertEquals(product, result);
        Mockito.verify(repository).create(product);
    }

    @Test
    void testFindAll() {
        Iterator<Product> iterator =
                List.of(new Product(), new Product()).iterator();

        Mockito.when(repository.findAll()).thenReturn(iterator);

        List<Product> products = service.findAll();

        assertEquals(2, products.size());
        Mockito.verify(repository).findAll();
    }

    @Test
    void testFindById() {
        Product product = new Product();
        Mockito.when(repository.findById("1")).thenReturn(product);

        Product result = service.findById("1");

        assertNotNull(result);
        assertEquals(product, result);
    }

    @Test
    void testUpdate() {
        Product product = new Product();
        service.update(product);

        Mockito.verify(repository).update(product);
    }

    @Test
    void testDelete() {
        service.delete("1");
        Mockito.verify(repository).delete("1");
    }
}