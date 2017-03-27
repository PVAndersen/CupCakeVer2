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
public class TransactionFailureException extends Exception{
    
    public TransactionFailureException(String Message){
        
        super(Message);
    }
    
}
