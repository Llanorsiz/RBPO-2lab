package kurban.softwareProducts.softwareProduct.web;

import kurban.softwareProducts.softwareProduct.model.SoftwareProduct;
import kurban.softwareProducts.softwareProduct.service.SoftwareProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/software-products")
@RequiredArgsConstructor
public class SoftwareProductController {
    private final SoftwareProductService softwareProductService;

    @GetMapping
    public List<SoftwareProduct> getSoftwareProducts() {
        return softwareProductService.getSoftwareProducts();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public SoftwareProduct createSoftwareProduct(@RequestBody SoftwareProduct product) {
        return softwareProductService.createSoftwareProduct(product);
    }

    @PutMapping("/{softwareProductId}")
    public SoftwareProduct updateSoftwareProduct(@PathVariable Long softwareProductId, @RequestBody SoftwareProduct product) {
        return softwareProductService.updateSoftwareProduct(softwareProductId, product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{softwareProductId}")
    public void deleteSoftwareProduct(@PathVariable Long softwareProductId) {
        softwareProductService.deleteSoftwareProduct(softwareProductId);
    }
}
