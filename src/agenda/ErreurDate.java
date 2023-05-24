/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda;

/**
 *
 * @author catal
 */
public class ErreurDate extends Exception {

    public ErreurDate() {
        super();
    }

    // Overrides Exception's getMessage()
    @Override
    public String getMessage() {
        return "les informations ne peuvent pas être analysées en date valide";
    }

}
