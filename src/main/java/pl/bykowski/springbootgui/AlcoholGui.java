package pl.bykowski.springbootgui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@Route("alcohol")
public class AlcoholGui extends VerticalLayout {


    private AlcoholRepo alcoholRepo;

    @Autowired
    public AlcoholGui(AlcoholRepo alcoholRepo) {

        TextField textFieldName = new TextField("Name");
        TextField textFieldPrice = new TextField("Price");
        Button button = new Button("Add!", new Icon(VaadinIcon.GLASS));
        TextField textFieldImage = new TextField("Image URL");
        ComboBox<PowerLevel> powerLevelComboBox
                = new ComboBox<>("Pover of drink", PowerLevel.values());

        button.addClickListener(clickEvent -> {
            Alcohol alcohol = new Alcohol();
            alcohol.setName(textFieldName.getValue());
            alcohol.setPrice(new BigDecimal(textFieldPrice.getValue()));
            alcohol.setPowerLevel(powerLevelComboBox.getValue());
            alcohol.setImageUrl(textFieldImage.getValue());
            alcoholRepo.save(alcohol);

            add(new Image("https://i.sadistic.pl/pics/7d391b7238ce.gif", "dodano"));
            add("DODANO NOWĄ POZYCJE! :) ");

        });

        add(textFieldName, textFieldPrice, powerLevelComboBox, textFieldImage, button);





    }
}
