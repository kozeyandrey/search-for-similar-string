public class Product {
    private Integer id;
    private String[] names;
    private Boolean checked;

    public Product(Integer id, String[] names, Boolean checked) {
        this.id = id;
        this.names = names;
        this.checked = checked;
    }

    public Integer getId() {
        return id;
    }

    public String[] getNames() {
        return names;
    }

    public Boolean getChecked() {
        return checked;
    }
}
