package data;

import java.util.ArrayList;
import java.util.List;

public class OutputData {
    private List<Variant> variantList;

    public OutputData() {
        this.variantList = new ArrayList<>();
    }

    public OutputData(Solution solution) {
        this.variantList = solution.getResult();
    }

    public OutputData(List<Variant> variants) {
        this.variantList = variants;
    }

    public List<Variant> getVariantList() {
        return variantList;
    }

    public void setVariantList(List<Variant> variantList) {
        this.variantList = variantList;
    }
}
