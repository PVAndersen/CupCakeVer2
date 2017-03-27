/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crashandburn;

/**
 *
 * @author PVA
 */
public class WrongLoginException extends Exception{
    
    public WrongLoginException(String message)
    {
        super(message);
    }
}
