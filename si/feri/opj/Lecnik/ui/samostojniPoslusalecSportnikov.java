package si.feri.opj.Lecnik.ui;

import si.feri.opj.Lecnik.Osebe.Sportnik;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The class samostojniPoslusalecSportnikov implements the ActionListener interface and is used to remove
 * selected athletes from a JComboBox component. It receives a JComboBox component and a DefaultComboBoxModel
 * that holds athlete objects.
 */

public class samostojniPoslusalecSportnikov implements ActionListener {

    private JComboBox izbraniComboBox;
    private DefaultComboBoxModel<Sportnik> sportnikCombo;

    /**
     * Constructs a new 'samostojniPoslusalecSportnikov' object with the given 'JComboBox' and 'DefaultComboBoxModel'
     * components that holds athlete objects.
     * @param comboBox the JComboBox component that holds athlete objects.
     * @param sportnik the DefaultComboBoxModel component that holds athlete objects.
     */
    public samostojniPoslusalecSportnikov(JComboBox comboBox, DefaultComboBoxModel<Sportnik> sportnik) {
        this.izbraniComboBox = comboBox;
        this.sportnikCombo = sportnik;
    }

    /**
     * Removes selected athletes from the 'DefaultComboBoxModel' component when an action is performed.
     * @param e the action event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (izbraniComboBox.getSelectedIndex() != -1) {
            System.out.println(sportnikCombo.getElementAt(izbraniComboBox.getSelectedIndex()));
            sportnikCombo.removeElementAt(izbraniComboBox.getSelectedIndex());
            izbraniComboBox.setSelectedIndex(-1);
        }
    }
}
