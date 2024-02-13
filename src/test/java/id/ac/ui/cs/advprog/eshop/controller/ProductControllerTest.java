package id.ac.ui.cs.advprog.eshop.controller;


import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.apache.hc.core5.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@AutoConfigureJsonTesters
@WebMvcTest(ProductController.class)
public class ProductControllerTest{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService service;

    @Autowired
    private JacksonTester<Product> jsonProduct;


    @Test
    void testHomePage() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/"))
                .andReturn().getResponse();

        assertEquals(response.getStatus(), HttpStatus.SC_OK);
    }

    @Test
    void testProductListPage() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/product/list"))
                .andReturn().getResponse();

        assertEquals(response.getStatus(), HttpStatus.SC_OK);
    }

    @Test
    void testCreateProductPage() throws Exception{
        MockHttpServletResponse response = mockMvc.perform(get("/product/create"))
                .andReturn().getResponse();

        assertEquals(response.getStatus(), HttpStatus.SC_OK);
    }

    @Test
    void testEditProductPage() throws Exception{
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);

        Mockito.when(service.get("eb558e9f-1c39-460e-8860-71af6af63bd6")).thenReturn(product1);

        MockHttpServletResponse response = mockMvc.perform(
                        get("/product/edit/eb558e9f-1c39-460e-8860-71af6af63bd6"))
                .andReturn().getResponse();

        assertEquals(response.getStatus(), HttpStatus.SC_OK);
    }

    @Test
    void testCreateProduct() throws Exception {
        Product product = new Product();
        product.setProductName("TestProduct");
        product.setProductQuantity(100);

        String json = jsonProduct.write(product).getJson();
        MockHttpServletResponse response = mockMvc.perform(
                        post("/product/create")
                                .contentType("application/json")
                                .content(json != null ? json : ""))
                .andReturn().getResponse();
        assert(response.getStatus() == HttpStatus.SC_MOVED_TEMPORARILY);
    }

    @Test
    void testDeleteProduct() throws Exception {
        String productId = "testProductId";

        MockHttpServletResponse response = mockMvc.perform(delete("/product/delete/{id}", productId))
                .andReturn().getResponse();

        assertEquals(HttpStatus.SC_MOVED_TEMPORARILY, response.getStatus());
    }

    @Test
    void testEditProduct() throws Exception {
        String productId = "testProductId";
        Product updatedProduct = new Product();
        updatedProduct.setProductName("UpdatedTestProduct");
        updatedProduct.setProductQuantity(50);

        String json = jsonProduct.write(updatedProduct).getJson();

        MockHttpServletResponse response = mockMvc.perform(
                        put("/product/edit/{productId}", productId)
                                .contentType("application/json")
                                .content(json != null ? json : ""))
                .andReturn().getResponse();

        assertEquals(HttpStatus.SC_MOVED_TEMPORARILY, response.getStatus());
    }

}
