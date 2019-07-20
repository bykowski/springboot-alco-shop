package pl.bykowski.springbootgui;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("show-alcohol")
public class AlcoholShowGui extends VerticalLayout {


    private AlcoholRepo alcoholRepo;

    @Autowired
    public AlcoholShowGui(AlcoholRepo alcoholRepo) {

        Grid<Alcohol> grid = new Grid<>(Alcohol.class);
        grid.setItems(alcoholRepo.findAll());

        grid.removeColumnByKey("id");
        grid.removeColumnByKey("imageUrl");

        grid.addColumn(new ComponentRenderer<>(alco  -> {
            Image image = new Image(alco.getImageUrl(), "image");
            return image;
        })).setHeader("Image");

        add(grid);
    }
}
