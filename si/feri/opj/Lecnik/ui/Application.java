package si.feri.opj.Lecnik.ui;

import si.feri.opj.Lecnik.Izjeme.DodajanjeSportnikaException;
import si.feri.opj.Lecnik.Izjeme.DodajanjeTekmeException;
import si.feri.opj.Lecnik.Izjeme.TipPanogeException;
import si.feri.opj.Lecnik.Organizacija.SportnaPanoga;
import si.feri.opj.Lecnik.Organizacija.Tekma;
import si.feri.opj.Lecnik.Organizacija.Trening;
import si.feri.opj.Lecnik.Osebe.Sportnik;
import si.feri.opj.Lecnik.Prostori.Dvorana;
import si.feri.opj.Lecnik.Prostori.Prizorisce;
import si.feri.opj.Lecnik.Prostori.Stadion;
import si.feri.opj.Lecnik.Termini.Termin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.text.Collator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

import static si.feri.opj.Lecnik.Organizacija.SportnaPanoga.*;

public class Application {
    private JPanel Main;
    private JTabbedPane Aplikacija;
    private JPanel Prizorisce;
    private JTextField nazivPrizorisca;
    private JTextField telefonPrizorisca;
    private JRadioButton atletikaPrizorisceButton;
    private JRadioButton judoPrizorisceButton;
    private JLabel ustvariPrizorisce;
    private JComboBox dropdownDvoran;
    private JButton dodajPrizorisce;
    private JButton izbrisiDvoranoButton;
    private JPanel Dogodek;
    private JPanel Sportnik;
    private JLabel ustvariDogodek;
    private JRadioButton tekmaButton;
    private JRadioButton treningButton;
    private JTextField fieldNazivDogodka;
    private JTextField fieldImeTrenerja;
    private JButton dodajDogodekButton;
    private JComboBox tekmeComboBox3;
    private JRadioButton potrjenoTekmaButton;
    private JRadioButton odpovedanoTekmaButton;
    private JButton izbrišiDogodekButton;
    private JTextField imeSportnik;
    private JTextField priimekSportnik;
    private JTextField stevilkaSportnik;
    private JTextField datumSportnik;
    private JRadioButton ATLETIKAButton;
    private JRadioButton JUDOButton;
    private JRadioButton ODBOJKAButton;
    private JComboBox sportnikOdstraniCombo;
    private JButton izbrišiSportnikaButton;
    private JPanel Organizacija;
    private JComboBox organizacijaSportniki;
    private JComboBox organizacijaTekme;
    private JComboBox organizacijaTekme2;
    private JList organizacijaPrizorisce;
    private JButton organizacijaTekmaPrizorisceButton;
    private JButton DODAJButton1;
    private JButton organizacijaTekmaSportnikButton;
    private JComboBox sportnikIzberiCombo;
    private JComboBox tekmeComboBox2;
    private JComboBox organizacijaTekme3;
    private JComboBox organizacijaSportniki2;
    private JTextField organizacijaStevilka;
    private JButton organizacijaOdstraniSportnikaButton;
    private JTextArea organizacijaPriimek;
    private JButton ODSTRANIVSETEKMEButton;
    private JComboBox kapacitetaZasedenostDvorana;
    private JPanel PanelOrganizacija;
    private JPanel Dogodek1;
    private JPanel Dogodek2;
    private JPanel Dogodek3;
    private JPanel Dogodek4;
    private JPanel Sportnik1;
    private JPanel Sportnik2;
    private JPanel Sportnik3;
    private JPanel Sportnik31;
    private JPanel Sportnik32;
    private JRadioButton dvoranaButton;
    private JRadioButton stadionButton;
    private JSpinner dodatneDvoraneSpinner;
    private JRadioButton odbojkaPrizorisceButton;
    private JTextField lahkoTekmujeField;
    private JComboBox dropdownStadionov;
    private JButton izbrisiStadionButton;
    private JButton dodajSportnikaGumb;
    private JSpinner danSpinner;
    private JSpinner mesecSpinner;
    private JSpinner letoSpinner;
    private JLabel imeTrenerjaText;
    private JSpinner danSpinnerD;
    private JSpinner mesecSpinnerD;
    private JSpinner letoSpinnerD;
    private JSpinner ureSpinnerD;
    private JSpinner minuteSpinnerD;
    private JComboBox treningiComboBox;
    private JRadioButton odpovedanoTreningButton;
    private JRadioButton potrjenoTreningButton;
    private JSpinner spinnerSteviloPrijavljenih;
    private JSpinner kapacitetaPrizorisca;
    private JList listVsehPrizorisc;
    private JTextField DodajanjeSportnikaExceptionField;
    private JTextField TekmePanogeExceptionField;
    private JSpinner organizacijaStevilkaSpinner;
    private JTextField organizacijaAliJeDodan;
    private JButton PREVERIButton;
    private JComboBox organizacijaTekmex;
    private JTextField zasedenostDvoran;
    private JComboBox kapacitetaZasedenostStadion;
    private JList tekmeInPrizoriscaKapaciteta;
    private JButton OKButton;
    private JButton urediButton;
    private DefaultComboBoxModel<Sportnik> comboBoxSportnikov = new DefaultComboBoxModel<>();
    private ArrayList<Sportnik> arrayListSportnikov = new ArrayList<>();
    private DefaultComboBoxModel<Trening> comboBoxTreningov = new DefaultComboBoxModel<>();
    private ArrayList<Trening> arrayListTreningov = new ArrayList<>();
    private DefaultComboBoxModel<Tekma> comboBoxTekem = new DefaultComboBoxModel<>();
    private ArrayList<Tekma> arrayListTekem = new ArrayList<>();
    private DefaultComboBoxModel<Dvorana> comboBoxDvoran = new DefaultComboBoxModel<>();
    private ArrayList<Dvorana> arrayListDvoran = new ArrayList<>();
    private DefaultComboBoxModel<Stadion> comboBoxStadionov = new DefaultComboBoxModel<>();
    private ArrayList<Stadion> arrayListStadionov = new ArrayList<>();
    private DefaultListModel<Prizorisce> vsaPrizorisca = new DefaultListModel<>();
    private ArrayList<Prizorisce> arrayListVsehPrizorisc = new ArrayList<>();

    public Application() {

        izbrišiSportnikaButton.addActionListener(new samostojniPoslusalecSportnikov(sportnikOdstraniCombo, comboBoxSportnikov));

        class NotranjiBrisalecVrednosti implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                imeSportnik.setText(null);
                priimekSportnik.setText(null);
                stevilkaSportnik.setText(null);
                if ((Integer) danSpinner.getValue() != 0 || (Integer) mesecSpinner.getValue() != 0 || (Integer) letoSpinner.getValue() != 0) {
                    danSpinner.setValue(0);
                    mesecSpinner.setValue(0);
                    letoSpinner.setValue(0);
                }
            }
        }

        dodajSportnikaGumb.addActionListener(new ActionListener() {
            private SportnaPanoga preveriGumb() {
                if (ATLETIKAButton.isSelected()) {
                    return ATLETIKA;
                }
                if (JUDOButton.isSelected()) {
                    return JUDO;
                } else {
                    return ODBOJKA;
                }
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                Sportnik oseba = new Sportnik(imeSportnik.getText(), priimekSportnik.getText(),
                        Integer.valueOf(stevilkaSportnik.getText()), LocalDate.of((Integer) letoSpinner.getValue(),
                        (Integer) mesecSpinner.getValue(), (Integer) danSpinner.getValue()), preveriGumb());


                sportnikOdstraniCombo.setModel(comboBoxSportnikov);
                sportnikIzberiCombo.setModel(comboBoxSportnikov);
                comboBoxSportnikov.addElement(oseba);
                System.out.println("Na comboBoxu je " + comboBoxSportnikov.getElementAt(0));
                arrayListSportnikov.add(oseba);
                System.out.println("Na arrayListu je " + arrayListSportnikov.get(0));
                sportnikIzberiCombo.setSelectedIndex(-1);
                sportnikOdstraniCombo.setSelectedIndex(-1);

                NotranjiBrisalecVrednosti izbrisi = new NotranjiBrisalecVrednosti();
                izbrisi.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
            }
        });

        urediButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sportnikOdstraniCombo.getSelectedIndex() != -1) {
                    imeSportnik.setText(comboBoxSportnikov.getElementAt(sportnikOdstraniCombo.getSelectedIndex()).getIme());
                    priimekSportnik.setText(comboBoxSportnikov.getElementAt(sportnikOdstraniCombo.getSelectedIndex()).getPriimek());
                    stevilkaSportnik.setText(Integer.toString(comboBoxSportnikov.getElementAt(sportnikOdstraniCombo.
                            getSelectedIndex()).getStevilkaSportnika()));
                    danSpinner.setValue(comboBoxSportnikov.getElementAt(sportnikOdstraniCombo.getSelectedIndex()).getDatumRojstva().getDayOfMonth());
                    mesecSpinner.setValue(comboBoxSportnikov.getElementAt(sportnikOdstraniCombo.getSelectedIndex()).getDatumRojstva().getMonthValue());
                    letoSpinner.setValue(comboBoxSportnikov.getElementAt(sportnikOdstraniCombo.getSelectedIndex()).getDatumRojstva().getYear());
                    comboBoxSportnikov.removeElementAt(sportnikOdstraniCombo.getSelectedIndex());
                    arrayListSportnikov.remove(sportnikOdstraniCombo.getSelectedIndex());
                    sportnikOdstraniCombo.setSelectedIndex(-1);
                }
            }
        });

        sportnikIzberiCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sportnikIzberiCombo.getSelectedIndex() != -1) {
                    Tekma prazna = new Tekma();
                    if (prazna.lahkoTekmuje(comboBoxSportnikov.getElementAt(sportnikIzberiCombo.getSelectedIndex()))) {
                        lahkoTekmujeField.setText("Lahko tekmuje");
                    } else {
                        lahkoTekmujeField.setText("Ne sme tekmovati");
                    }

                }
            }
        });


        treningButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldImeTrenerja.setVisible(true);
                imeTrenerjaText.setVisible(true);
            }
        });
        tekmaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldImeTrenerja.setVisible(false);
                imeTrenerjaText.setVisible(false);

            }
        });
        dodajDogodekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Termin termin = new Termin(LocalDateTime.of((Integer) letoSpinnerD.getValue(), (Integer) mesecSpinnerD.getValue(),
                        (Integer) danSpinnerD.getValue(), (Integer) ureSpinnerD.getValue(), (Integer) minuteSpinnerD.getValue()));
                if (tekmaButton.isSelected()) {
                    Tekma novaTekma = new Tekma(fieldNazivDogodka.getText(), termin);
                    tekmeComboBox3.setModel(comboBoxTekem);
                    tekmeComboBox2.setModel(comboBoxTekem);
                    comboBoxTekem.addElement(novaTekma);
                    arrayListTekem.add(novaTekma);
                } else if (treningButton.isSelected()) {
                    Trening novTrening = new Trening(fieldNazivDogodka.getText(), termin, fieldImeTrenerja.getText());
                    treningiComboBox.setModel(comboBoxTreningov);
                    comboBoxTreningov.addElement(novTrening);
                    arrayListTreningov.add(novTrening);
                    treningiComboBox.setSelectedIndex(-1);
                }

                //Resetiranje
                treningButton.setSelected(false);
                tekmaButton.setSelected(false);
                fieldNazivDogodka.setText(null);
                fieldImeTrenerja.setText(null);
                danSpinnerD.setValue(0);
                mesecSpinnerD.setValue(0);
                letoSpinnerD.setValue(0);
                ureSpinnerD.setValue(0);
                minuteSpinnerD.setValue(0);
            }
        });
        izbrišiDogodekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tekmeComboBox3.getSelectedIndex() != -1) {
                    comboBoxTekem.removeElementAt(tekmeComboBox3.getSelectedIndex());
                    arrayListTekem.remove(tekmeComboBox3.getSelectedIndex());
                    tekmeComboBox3.setSelectedIndex(-1);
                } else if (treningiComboBox.getSelectedIndex() != -1) {
                    comboBoxTreningov.removeElementAt(treningiComboBox.getSelectedIndex());
                    arrayListTreningov.remove(treningiComboBox.getSelectedIndex());
                    treningiComboBox.setSelectedIndex(-1);
                }
            }
        });
        tekmeComboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tekmeComboBox3.getSelectedIndex() != -1) {
                    if (comboBoxTekem.getElementAt(tekmeComboBox3.getSelectedIndex()).isOdpovedano()) {
                        odpovedanoTekmaButton.setSelected(true);
                    } else {
                        potrjenoTekmaButton.setSelected(true);
                    }
                }
            }
        });
        tekmeComboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tekmeComboBox2.getSelectedIndex() != -1) {
                    spinnerSteviloPrijavljenih.setValue(comboBoxTekem.getElementAt(
                            tekmeComboBox2.getSelectedIndex()).vrniSteviloSportnikovNaTekmi());
                }
            }
        });
        treningiComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (treningiComboBox.getSelectedIndex() != -1) {
                    if (comboBoxTreningov.getElementAt(treningiComboBox.getSelectedIndex()).isOdpovedano()) {
                        odpovedanoTreningButton.setSelected(true);
                    } else {
                        potrjenoTreningButton.setSelected(true);
                    }
                }
            }
        });


        dvoranaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodatneDvoraneSpinner.setVisible(true);
            }
        });

        stadionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodatneDvoraneSpinner.setVisible(false);
            }
        });

        dodajPrizorisce.addActionListener(new ActionListener() {

            private SportnaPanoga dolociSportnoPanogo() {
                if (atletikaPrizorisceButton.isSelected()) {
                    return ATLETIKA;
                } else if (judoPrizorisceButton.isSelected()) {
                    return JUDO;
                } else {
                    return ODBOJKA;
                }
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                listVsehPrizorisc.setModel(vsaPrizorisca);
                if (stadionButton.isSelected()) {
                    Stadion noviStadion = new Stadion(nazivPrizorisca.getText(), Long.parseLong(telefonPrizorisca.getText()),
                            (Integer) kapacitetaPrizorisca.getValue(), dolociSportnoPanogo());
                    dropdownStadionov.setModel(comboBoxStadionov);
                    comboBoxStadionov.addElement(noviStadion);
                    arrayListStadionov.add(noviStadion);
                    vsaPrizorisca.addElement(noviStadion);
                    arrayListVsehPrizorisc.add(noviStadion);
                    dropdownStadionov.setSelectedIndex(-1);
                }
                if (dvoranaButton.isSelected()) {
                    Dvorana novaDvorana = new Dvorana(nazivPrizorisca.getText(), Long.parseLong(telefonPrizorisca.getText()),
                            (Integer) kapacitetaPrizorisca.getValue(), dolociSportnoPanogo(), (Integer) dodatneDvoraneSpinner.getValue());
                    dropdownDvoran.setModel(comboBoxDvoran);
                    comboBoxDvoran.addElement(novaDvorana);
                    arrayListDvoran.add(novaDvorana);
                    vsaPrizorisca.addElement(novaDvorana);
                    arrayListVsehPrizorisc.add(novaDvorana);
                    dropdownDvoran.setSelectedIndex(-1);
                }

                //resetiranje
                nazivPrizorisca.setText(null);
                telefonPrizorisca.setText(null);
                kapacitetaPrizorisca.setValue(0);
                atletikaPrizorisceButton.setSelected(false);
                judoPrizorisceButton.setSelected(false);
                odbojkaPrizorisceButton.setSelected(false);
                dodatneDvoraneSpinner.setValue(0);
            }
        });
        izbrisiDvoranoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dropdownDvoran.getSelectedIndex() != -1) {
                    comboBoxDvoran.removeElementAt(dropdownDvoran.getSelectedIndex());
                    arrayListDvoran.remove(dropdownDvoran.getSelectedIndex());
                    dropdownDvoran.setSelectedIndex(-1);
                }
            }
        });
        izbrisiStadionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dropdownStadionov.getSelectedIndex() != -1) {
                    comboBoxStadionov.removeElementAt(dropdownStadionov.getSelectedIndex());
                    arrayListStadionov.remove(dropdownStadionov.getSelectedIndex());
                    dropdownStadionov.setSelectedIndex(-1);
                }
            }
        });
        ODSTRANIVSETEKMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vsaPrizorisca.getElementAt(listVsehPrizorisc.getSelectedIndex()).odstraniTekme();
            }
        });

        tekmeInPrizoriscaKapaciteta.setModel(vsaPrizorisca);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vsaPrizorisca.getElementAt(tekmeInPrizoriscaKapaciteta.getSelectedIndex()) != null) {
                    zasedenostDvoran.setText("Zasedenost: " + vsaPrizorisca.getElementAt(tekmeInPrizoriscaKapaciteta.
                            getSelectedIndex()).vrniZasedenost() + " . Kapaciteta: " + vsaPrizorisca.getElementAt
                            (tekmeInPrizoriscaKapaciteta.getSelectedIndex()).vrniKapaciteto());
                }
            }
        });


        organizacijaSportniki.setModel(comboBoxSportnikov);
        organizacijaTekme.setModel(comboBoxTekem);
        organizacijaTekme2.setModel(comboBoxTekem);
        organizacijaPrizorisce.setModel(vsaPrizorisca);
        organizacijaTekme3.setModel(comboBoxTekem);
        organizacijaSportniki2.setModel(comboBoxSportnikov);
        organizacijaTekmex.setModel(comboBoxTekem);

        organizacijaTekmaSportnikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (organizacijaSportniki.getSelectedIndex() != -1 && organizacijaTekme.getSelectedIndex() != -1) {
                    try {
                        comboBoxTekem.getElementAt(organizacijaTekme.getSelectedIndex()).dodajSportnikaNaTekmo(
                                comboBoxSportnikov.getElementAt(organizacijaSportniki.getSelectedIndex()));
                    } catch (DodajanjeSportnikaException ex) {
                        DodajanjeSportnikaExceptionField.setText("Športnik je premlad ali prestar.");
                        try {
                            FileWriter dokumentZNapakami = new FileWriter("dogodki.txt", true);
                            dokumentZNapakami.write(LocalDateTime.now() + " OPOZORILO Športnik je premlad ali prestar \n");
                            System.out.println(dokumentZNapakami);
                            dokumentZNapakami.flush();
                        } catch (IOException exc) {
                            throw new RuntimeException(exc);
                        }
                    }
                    organizacijaTekme.setSelectedIndex(-1);
                    organizacijaSportniki.setSelectedIndex(-1);
                }

            }
        });
        organizacijaTekmaPrizorisceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (organizacijaTekme2.getSelectedIndex() != -1 && organizacijaPrizorisce.getSelectedIndex() != -1) {
                    try {
                        vsaPrizorisca.getElementAt(organizacijaPrizorisce.getSelectedIndex()).dodajTekmo
                                (comboBoxTekem.getElementAt(organizacijaTekme2.getSelectedIndex()));
                        System.out.println(vsaPrizorisca.getElementAt(organizacijaPrizorisce.getSelectedIndex()).vrniZasedenost());
                    } catch (DodajanjeTekmeException ex) {
                        TekmePanogeExceptionField.setText("Tekma se ne more začeti po 20. uri");
                        try {
                            FileWriter dokumentZNapakami = new FileWriter("dogodki.txt", true);
                            dokumentZNapakami.write(LocalDateTime.now() + " OPOZORILO Tekma se ne more začeti po 20. uri \n");
                            dokumentZNapakami.flush();
                        } catch (IOException exc) {
                            throw new RuntimeException(exc);
                        }
                    } catch (TipPanogeException ex) {
                        TekmePanogeExceptionField.setText("Tekme ni mogoče dodati na prizorišče zaradi neustreznega tipa panoge");
                        try {
                            FileWriter dokumentZNapakami = new FileWriter("dogodki.txt", true);
                            dokumentZNapakami.write(LocalDateTime.now() + " OPOZORILO Tekme ni mogoče dodati na prizorišče zaradi neustreznega tipa panoge \n}");
                            dokumentZNapakami.flush();
                        } catch (IOException exc) {
                            throw new RuntimeException(exc);
                        }
                    }

                    if (vsaPrizorisca.getElementAt(organizacijaPrizorisce.getSelectedIndex()) instanceof Dvorana) {
                        for (int i = 0; i < comboBoxDvoran.getSize(); i++) {
                            if (vsaPrizorisca.getElementAt(organizacijaPrizorisce.getSelectedIndex()) == (
                                    comboBoxDvoran.getElementAt(i))) {
                                try {
                                    comboBoxDvoran.getElementAt(i).dodajTekmo(comboBoxTekem.getElementAt(organizacijaTekme2.getSelectedIndex()));
                                } catch (DodajanjeTekmeException ex) {
                                    TekmePanogeExceptionField.setText("Tekma se ne more začeti po 20. uri");
                                    try {
                                        FileWriter dokumentZNapakami = new FileWriter("dogodki.txt", true);
                                        dokumentZNapakami.write(LocalDateTime.now() + " OPOZORILO Tekma se ne more začeti po 20. uri \n");
                                        dokumentZNapakami.flush();
                                    } catch (IOException exc) {
                                        throw new RuntimeException(exc);
                                    }
                                } catch (TipPanogeException ex) {
                                    TekmePanogeExceptionField.setText("Tekme ni mogoče dodati na prizorišče zaradi neustreznega tipa panoge");
                                    try {
                                        FileWriter dokumentZNapakami = new FileWriter("dogodki.txt", true);
                                        dokumentZNapakami.write(LocalDateTime.now() + "OPOZORILO Tekme ni mogoče dodati na prizorišče zaradi neustreznega tipa panoge \n");
                                        dokumentZNapakami.flush();
                                    } catch (IOException exc) {
                                        throw new RuntimeException(exc);
                                    }
                                }
                                System.out.println("tekma dodana na dvorano");
                                System.out.println(comboBoxDvoran.getElementAt(i).vrniZasedenost());
                                System.out.println(vsaPrizorisca.getElementAt(organizacijaPrizorisce.getSelectedIndex()).vrniZasedenost());
                            }
                        }
                    } else if (vsaPrizorisca.getElementAt(organizacijaPrizorisce.getSelectedIndex()) instanceof Stadion) {
                        for (int j = 0; j < comboBoxStadionov.getSize(); j++) {
                            if (comboBoxStadionov.getElementAt(j) == vsaPrizorisca.get(organizacijaPrizorisce.getSelectedIndex())) {
                                try {
                                    comboBoxStadionov.getElementAt(j).dodajTekmo(comboBoxTekem.getElementAt(organizacijaTekme2.getSelectedIndex()));
                                } catch (DodajanjeTekmeException ex) {
                                    TekmePanogeExceptionField.setText("Tekma se ne more začeti po 20. uri");
                                    try {
                                        FileWriter dokumentZNapakami = new FileWriter("dogodki.txt", true);
                                        dokumentZNapakami.write(LocalDateTime.now() + "OPOZORILO Tekma se ne more začeti po 20. uri \n");
                                        dokumentZNapakami.flush();
                                    } catch (IOException exc) {
                                        throw new RuntimeException(exc);
                                    }
                                } catch (TipPanogeException ex) {
                                    TekmePanogeExceptionField.setText("Tekme ni mogoče dodati na prizorišče zaradi neustreznega tipa panoge");
                                    try {
                                        FileWriter dokumentZNapakami = new FileWriter("dogodki.txt", true);
                                        dokumentZNapakami.write(LocalDateTime.now() + "OPOZORILO Tekme ni mogoče dodati na prizorišče zaradi neustreznega tipa panoge \n");
                                        dokumentZNapakami.flush();
                                    } catch (IOException exc) {
                                        throw new RuntimeException(exc);
                                    }
                                }
                                System.out.println("tekma dodana na stadion");
                                System.out.println(comboBoxStadionov.getElementAt(j).vrniZasedenost());
                                System.out.println(vsaPrizorisca.getElementAt(organizacijaPrizorisce.getSelectedIndex()).vrniZasedenost());
                            }
                        }

                    }

                    organizacijaTekme2.setSelectedIndex(-1);
                    organizacijaPrizorisce.setSelectedIndex(-1);
                }
            }
        });
        organizacijaOdstraniSportnikaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (organizacijaTekme3.getSelectedIndex() != -1) {
                    if (organizacijaSportniki2.getSelectedIndex() != -1) {
                        comboBoxTekem.getElementAt(organizacijaTekme3.getSelectedIndex()).odstraniSportnikaSTekme
                                (comboBoxSportnikov.getElementAt(organizacijaSportniki2.getSelectedIndex()));
                        organizacijaTekme3.setSelectedIndex(-1);
                        organizacijaTekme2.setSelectedIndex(-1);
                    } else if (organizacijaStevilkaSpinner.getValue() != null) {
                        comboBoxTekem.getElementAt(organizacijaTekme3.getSelectedIndex()).odstraniSportnikaSTekme
                                ((Integer) organizacijaStevilkaSpinner.getValue());
                        organizacijaTekme3.setSelectedIndex(-1);
                        organizacijaStevilkaSpinner.setValue(null);
                    }
                }
            }
        });
        PREVERIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (organizacijaPriimek.getText() != null && organizacijaTekmex.getSelectedIndex() != -1) {
                    if (comboBoxTekem.getElementAt(organizacijaTekmex.getSelectedIndex()).sportnikObstaja(organizacijaPriimek.getText())) {
                        organizacijaAliJeDodan.setText("true");
                    } else {
                        organizacijaAliJeDodan.setText("false");
                    }
                }
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplication");

        Application application = new Application();
        frame.setContentPane(application.Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                application.saveData();
                frame.dispose();
            }

            @Override
            public void windowOpened(WindowEvent e) {

                application.readDataFromFile();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    public void saveData() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Aplikacija.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            System.out.println(arrayListSportnikov.size());

            objectOutputStream.writeObject(arrayListSportnikov);
            objectOutputStream.writeObject(arrayListTreningov);
            objectOutputStream.writeObject(arrayListTekem);
            objectOutputStream.writeObject(arrayListDvoran);
            objectOutputStream.writeObject(arrayListStadionov);

            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Shranjeno v Aplikacija.ser");
        } catch (IOException ex) {
            ex.printStackTrace();
            try {
                FileWriter dokumentZNapakami = new FileWriter("dogodki.txt", true);
                dokumentZNapakami.write(LocalDateTime.now() + " NAPAKA Serializacija ni bila mogoča \n");
                dokumentZNapakami.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void readDataFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("Aplikacija.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Comparator<Sportnik> sortirnik = new Comparator<>() {
                @Override
                    public int compare(Sportnik prviSportnik, Sportnik drugiSportnik) {
                    Collator sloveneCollator = Collator.getInstance(new Locale("sl"));
                    return sloveneCollator.compare(prviSportnik.getIme(), drugiSportnik.getIme());
                }
            };

            arrayListSportnikov = (ArrayList<Sportnik>) objectInputStream.readObject();
            System.out.println(arrayListSportnikov.size());
            for (int i = 0; i < arrayListSportnikov.size(); i++) {
                Collections.sort(arrayListSportnikov, sortirnik);
                Sportnik sportnik = arrayListSportnikov.get(i);
                comboBoxSportnikov.addElement(sportnik);
                System.out.println(sportnik);
            }

            arrayListTreningov = (ArrayList<Trening>) objectInputStream.readObject();
            for (int i = 0; i < arrayListTreningov.size(); i++) {
                Trening trening = arrayListTreningov.get(i);
                comboBoxTreningov.addElement(trening);
            }

            arrayListTekem = (ArrayList<Tekma>) objectInputStream.readObject();
            for (int i = 0; i < arrayListTekem.size(); i++) {
                Tekma tekma = arrayListTekem.get(i);
                comboBoxTekem.addElement(tekma);
                System.out.println(tekma);
            }

            arrayListDvoran = (ArrayList<Dvorana>) objectInputStream.readObject();
            for (int i = 0; i < arrayListDvoran.size(); i++) {
                Dvorana dvorana = arrayListDvoran.get(i);
                comboBoxDvoran.addElement(dvorana);
                Prizorisce prizorisce = arrayListDvoran.get(i);
                vsaPrizorisca.addElement(prizorisce);
            }

            arrayListStadionov = (ArrayList<Stadion>) objectInputStream.readObject();
            for (int i = 0; i < arrayListStadionov.size(); i++) {
                Stadion stadion = arrayListStadionov.get(i);
                comboBoxStadionov.addElement(stadion);
                Prizorisce prizorisce = arrayListStadionov.get(i);
                vsaPrizorisca.addElement(prizorisce);
            }

            objectInputStream.close();
            fileInputStream.close();

            System.out.println("Je vrnjeno");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            try {
                FileWriter dokumentZNapakami = new FileWriter("dogodki.txt", true);
                dokumentZNapakami.write(LocalDateTime.now() + " NAPAKA Datoteka ni bila najdena \n");
                dokumentZNapakami.flush();
            } catch (IOException exc) {
                throw new RuntimeException(exc);
            }
        } catch (IOException e) {
            e.printStackTrace();
            try {
                FileWriter dokumentZNapakami = new FileWriter("dogodki.txt", true);
                dokumentZNapakami.write(LocalDateTime.now() + " NAPAKA Deserializacija ni bila mogoča \n");
                dokumentZNapakami.flush();
            } catch (IOException exc) {
                throw new RuntimeException(exc);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            try {
                FileWriter dokumentZNapakami = new FileWriter("dogodki.txt", true);
                dokumentZNapakami.write(LocalDateTime.now() + " NAPAKA Izbrani razred pri deserializaciji ni bil najden \n");
                dokumentZNapakami.flush();
            } catch (IOException exc) {
                throw new RuntimeException(exc);
            }
        }
    }
}
