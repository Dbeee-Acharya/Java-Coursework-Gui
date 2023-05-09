/**
 * The BankGUI class contains all the required GUI components along with event handling
 * it calls the debitCard and CreditCard methods through object casting as required and 
 * displays the required information
 */

import javax.swing.*; //Importing the java swing components

import java.awt.event.*; //For event handling
import java.awt.color.*; //to set color
import java.awt.Font; // to set font
import java.util.ArrayList; //to use arrayList

  public class BankGUI implements ActionListener {

    //creating a new JFrame instance
    private JFrame mainJFrame,
            checkBalance_frame,
            cancelCredit_frame; 
    
    /* Jpanels */
    private JPanel mainScreen_panel,
            addDebitCard_panel,
            addCreditCard_panel,
            setCredit_panel,
            withdraw_panel;

    /* The buttons used for Welcome Screen are declared here
     */
    private JButton addClientNameMainScreen_button,
            changeClientNameMainScreen_button,
            addDebitCardMainScreen_button, 
            addCreditCardMainScreen_button,
            setCreditMainScreen_button,
            checkBalanceMainScreen_button,
            debitCardInfoMainScreen_button,
            creditCardInfoMainScreen_button,
            withdrawMainScreen_button,
            cancelCreditMainScreen_button,

            //add debit card buttons
            addDebitCard_button,
            clearAddDebit_button,
            exitAddDebit_button,

            //add credit card button
            addCreditCard_button,
            clearAddCredit_button,
            exitAddCredit_button,

            //withdraw buttons
            withdraw_button,
            clearWithdraw_button,
            exitWithdraw_button,
            
            //Credit Limit buttons
            setCredit_button,
            clearSetCredit_button,
            exitSetCredit_button,
            
            // Cancel Credit Buttons
            cancelCredit_button;
            
    /* JLabel used */
    private JLabel mainScreenWelcome_label,
            mainScreenInstruction_label,
            
            //debit card screen labels
            welcomeUserAddDebit_label,
            issuerBankAddDebit_label,
            bankAccountAddDebit_label,
            cardIdAddDebit_label,
            balanceAddDebit_label,
            pinNumberAddDebit_label,

            // Credit Card screen labels
            welcomeUserAddCredit_label,
            issuerBankAddCredit_label,
            bankAccountAddCredit_label,
            cardIdAddCredit_label,
            balanceAddCredit_label,
            cvcNumberAddCredit_label,
            interestAddCredit_label,
            dayAddCredit_label,
            monthAddCredit_label,
            yearAddCredit_label,
            
            // Withdraw Screen Labels
            welcomeUserWithdraw_label,
            balanceWithdraw_label,
            cardIdWithdraw_label,
            withdrawalAmount_label,
            pinNumberWithdraw_label,
            dayWithdraw_label,
            monthWithdraw_label,
            yearWithdraw_label,
            
            // Check Balance Screen Label
            welcomeUserCheckBalance_label,
            currentBalanceCheckBalance_label,
            
            // Set Credit labels
            welcomeUserSetCredit_label,
            cardIdSetCredit_label,
            creditLimitSetCredit_label,
            gracePeriodSetCredit_label,
            
            //Cancel Credit Labels
            welcomeUserCancelCredit_label,
            cardIdCancelCredit_label;
            

    /* TextFields used */
    private JTextField clientNameMainScreen_textField,
            
            // debit card screen TextFields
            issuerBankAddDebit_textField,
            bankAccountAddDebit_textField,
            cardIdAddDebit_textField,
            balanceAddDebit_textField,
            pinNumberAddDebit_textFiled,
            
            // credit card screen textFields
            issuerBankAddCredit_textField,
            bankAccountAddCredit_textField,
            cardIdAddCredit_textField,
            balanceAddCredit_textField,
            cvcNumberAddCredit_textFiled,
            interestAddCredit_textField,
            
            //withdraw Screen textfields
            cardIdWithdraw_textField,
            withdrawalAmount_textField,
            pinNumberWithdraw_textField,
            
            // set credit limit screen 
            cardIdSetCredit_textField,
            creditLimit_textField,
            gracePeriod_textField,
            
            // Cancel Credit text field
            cardIdCancelCredit_textField;

    /* ComboBox used */
    private JComboBox<String> dateDayAddCredit_combo,
            dateMonthAddCredit_combo,
            dateYearAddCredit_combo,
            dateDayWithdraw_combo,
            dateMonthWithdraw_combo,
            dateYearWithdraw_combo;

    // Arrays to store date         
    private String[] dateDay = {
      "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", 
      "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", 
      "26", "27", "28", "29", "30", "31"
    };
    private String[] dateMonth = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private String[] dateYear = {"2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"};

    private ArrayList<BankCard> bankCard_ArrayList;

    /* Icons */
    private Icon addUser_icon = new ImageIcon("./icons/addUser.png"); //icon for add user
    private Icon addCard_icon = new ImageIcon("./icons/addCard.png"); //icon for adding debit and credit card
    private Icon checkBalance_icon = new ImageIcon("./icons/checkBalance.png"); //icon for checking balance
    private Icon card_icon = new ImageIcon("./icons/card.png"); //icon for credit and debit card
    private Icon withdraw_icon = new ImageIcon("./icons/withdraw.png"); //icon for withdraw
    private Icon sad_icon = new ImageIcon("./icons/sad.png"); // Icon for sad user
    private Icon clear_icon = new ImageIcon("./icons/clear.png"); // icon for clear info button
    private Icon exit_icon = new ImageIcon("./icons/exit.png"); // exit icon
    private Icon changeClient_icon = new ImageIcon("./icons/changeUser.png"); // change user icon
    private Icon cancelCard_icon = new ImageIcon("./icons/cancelCard.png"); // cancel credit icon
    private Icon stopHand_icon = new ImageIcon("./icons/stopHand.png"); // hand icon
    private Icon happy_icon = new ImageIcon("./icons/happyIcon.png");  // happy icon
    private Icon credit_icon = new ImageIcon("./icons/setCredit.png");  // happy icon
    
    /**
     * ALl the Jframe components are made inside its constructor
     */
    public BankGUI() {
      // Creating an arraylist
      bankCard_ArrayList = new ArrayList<BankCard>();

      mainJFrame = new JFrame("Bank GUI"); //Creating the main JFrame 
      checkBalance_frame = new JFrame("Current Balance"); // Frame for displaying balance information
      cancelCredit_frame = new JFrame("Cancel Credit Card"); // Frame for cancelling Credit card

      /* creating Jpanels*/
      mainScreen_panel = new JPanel();
      addDebitCard_panel = new JPanel();
      addCreditCard_panel = new JPanel();
      setCredit_panel = new JPanel();
      withdraw_panel = new JPanel();

      /* Initializing different fonts */
          Font headerFont = new Font(Font.DIALOG, Font.PLAIN, 24);
      Font inputLabelFont = new Font(Font.DIALOG, Font.PLAIN, 18);

      /* JLabel components */
      mainScreenWelcome_label = new JLabel("Welcome User,");
      mainScreenInstruction_label = new JLabel("Please add client name before proceeding");
      
      welcomeUserAddDebit_label = new JLabel("Welcome User");
      issuerBankAddDebit_label = new JLabel("Issuer Bank:");
      bankAccountAddDebit_label = new JLabel("Bank Account:");
      cardIdAddDebit_label = new JLabel("Card ID:");
      balanceAddDebit_label = new JLabel("Balance:");
      pinNumberAddDebit_label = new JLabel("PIN Number:");

      welcomeUserAddCredit_label = new JLabel("Welcome User");
      issuerBankAddCredit_label = new JLabel("Issuer Bank:");
      bankAccountAddCredit_label = new JLabel("Bank Account:");
      cardIdAddCredit_label = new JLabel("Card ID:");
      balanceAddCredit_label = new JLabel("Balance:");
      cvcNumberAddCredit_label = new JLabel("CVC Number:");
      interestAddCredit_label = new JLabel("Interest Rate:");
      dayAddCredit_label = new JLabel("Day:");
      monthAddCredit_label = new JLabel("Month:");
      yearAddCredit_label = new JLabel("Year:");

      welcomeUserWithdraw_label = new JLabel("Welcome User");
      cardIdWithdraw_label = new JLabel("Card ID:");
      balanceWithdraw_label = new JLabel("Balance:");
      withdrawalAmount_label = new JLabel("Withdrawal Amount:");
      pinNumberWithdraw_label = new JLabel("PIN Number:");
      dayWithdraw_label = new JLabel("Day:");
      monthWithdraw_label = new JLabel("Month:");
      yearWithdraw_label = new JLabel("Year:");

      welcomeUserCheckBalance_label = new JLabel("Welcome User");
      currentBalanceCheckBalance_label = new JLabel("balance");

      welcomeUserSetCredit_label = new JLabel("Welcome User");
      cardIdSetCredit_label = new JLabel("Card ID:");
      creditLimitSetCredit_label = new JLabel("Credit Limit");
      gracePeriodSetCredit_label = new JLabel("Grace Period:");

      welcomeUserCancelCredit_label = new JLabel("Welcome User");
      cardIdCancelCredit_label = new JLabel("Card ID:");

      /* setting fonts for JLabel */
      mainScreenWelcome_label.setFont(headerFont);
      mainScreenInstruction_label.setFont(inputLabelFont);
      welcomeUserAddDebit_label.setFont(inputLabelFont);
      issuerBankAddDebit_label.setFont(inputLabelFont);
      bankAccountAddDebit_label.setFont(inputLabelFont);
      cardIdAddDebit_label.setFont(inputLabelFont);
      balanceAddDebit_label.setFont(inputLabelFont);
      pinNumberAddDebit_label.setFont(inputLabelFont);
      welcomeUserAddCredit_label.setFont(headerFont);
      issuerBankAddCredit_label.setFont(inputLabelFont);
      bankAccountAddCredit_label.setFont(inputLabelFont);
      cardIdAddCredit_label.setFont(inputLabelFont);
      balanceAddCredit_label.setFont(inputLabelFont);
      cvcNumberAddCredit_label.setFont(inputLabelFont);
      interestAddCredit_label.setFont(inputLabelFont);
      dayAddCredit_label.setFont(inputLabelFont);
      monthAddCredit_label.setFont(inputLabelFont);
      yearAddCredit_label.setFont(inputLabelFont);
      welcomeUserWithdraw_label.setFont(headerFont);
      cardIdWithdraw_label.setFont(inputLabelFont);
      balanceWithdraw_label.setFont(headerFont);
      pinNumberWithdraw_label.setFont(inputLabelFont);
      withdrawalAmount_label.setFont(inputLabelFont);
      dayWithdraw_label.setFont(inputLabelFont);
      monthWithdraw_label.setFont(inputLabelFont);
      yearWithdraw_label.setFont(inputLabelFont);
      welcomeUserAddDebit_label.setFont(headerFont);
      currentBalanceCheckBalance_label.setFont(headerFont);
      welcomeUserSetCredit_label.setFont(headerFont);
      cardIdSetCredit_label.setFont(inputLabelFont);
      creditLimitSetCredit_label.setFont(inputLabelFont);
      gracePeriodSetCredit_label.setFont(inputLabelFont);
      welcomeUserCancelCredit_label.setFont(headerFont);
      cardIdCancelCredit_label.setFont(inputLabelFont);

      /*JButton Components*/
      addClientNameMainScreen_button = new JButton("Add Client", addUser_icon);
      changeClientNameMainScreen_button = new JButton("Change Client", changeClient_icon);

      addDebitCardMainScreen_button = new JButton("Add Debit Card", addCard_icon);
      addCreditCardMainScreen_button = new JButton("Add Credit Card", addCard_icon);
      setCreditMainScreen_button = new JButton("Set Credit", credit_icon);
      checkBalanceMainScreen_button = new JButton("Check Balance", checkBalance_icon);
      debitCardInfoMainScreen_button = new JButton("Debit Card Info", card_icon);
      creditCardInfoMainScreen_button = new JButton("Credit Card Info", card_icon);
      withdrawMainScreen_button = new JButton(" Withdraw", withdraw_icon);
      cancelCreditMainScreen_button = new JButton("Cancel Credit", cancelCard_icon);

      addDebitCard_button = new JButton("Add Card", addCard_icon);
      clearAddDebit_button = new JButton("Clear", clear_icon);
      exitAddDebit_button = new JButton("Exit", exit_icon);

      addCreditCard_button = new JButton("Add Card", addCard_icon);
      clearAddCredit_button= new JButton("Clear", clear_icon);
      exitAddCredit_button = new JButton("Exit", exit_icon);

      withdraw_button = new JButton("Withdraw", withdraw_icon);
      clearWithdraw_button= new JButton("Clear", clear_icon);
      exitWithdraw_button = new JButton("Exit", exit_icon);

      setCredit_button = new JButton("Set Credit", credit_icon);
      clearSetCredit_button = new JButton("Clear", clear_icon);
      exitSetCredit_button = new JButton("Exit", exit_icon);

      cancelCredit_button = new JButton("Cancel Credit", cancelCard_icon);

      /* Event Listener for Buttons */
      addClientNameMainScreen_button.addActionListener(this); 
      changeClientNameMainScreen_button.addActionListener(this);

      addDebitCardMainScreen_button.addActionListener(this);
      addCreditCardMainScreen_button.addActionListener(this);
      setCreditMainScreen_button.addActionListener(this);
      checkBalanceMainScreen_button.addActionListener(this);
      debitCardInfoMainScreen_button.addActionListener(this);
      creditCardInfoMainScreen_button.addActionListener(this);
      withdrawMainScreen_button.addActionListener(this);
      cancelCreditMainScreen_button.addActionListener(this);
      
      addDebitCard_button.addActionListener(this);
      clearAddDebit_button.addActionListener(this);
      exitAddDebit_button.addActionListener(this);

      addCreditCard_button.addActionListener(this);
      clearAddCredit_button.addActionListener(this);
      exitAddCredit_button.addActionListener(this);

      withdraw_button.addActionListener(this);
      clearWithdraw_button.addActionListener(this);
      exitWithdraw_button.addActionListener(this);

      setCredit_button.addActionListener(this);
      clearSetCredit_button.addActionListener(this);
      exitSetCredit_button.addActionListener(this);

      cancelCredit_button.addActionListener(this);

      /* JTextFeild Components */
      clientNameMainScreen_textField = new JTextField();
      
      issuerBankAddDebit_textField = new JTextField();
      bankAccountAddDebit_textField = new JTextField();
      cardIdAddDebit_textField = new JTextField();
      balanceAddDebit_textField = new JTextField();
      pinNumberAddDebit_textFiled = new JTextField();

      issuerBankAddCredit_textField = new JTextField();
      bankAccountAddCredit_textField = new JTextField();
      cardIdAddCredit_textField = new JTextField();
      balanceAddCredit_textField = new JTextField();
      cvcNumberAddCredit_textFiled = new JTextField();
      interestAddCredit_textField = new JTextField();

      cardIdWithdraw_textField = new JTextField();
      withdrawalAmount_textField = new JTextField();
      pinNumberWithdraw_textField = new JTextField();

      cardIdSetCredit_textField = new JTextField();
      creditLimit_textField = new JTextField();
      gracePeriod_textField = new JTextField();

      cardIdCancelCredit_textField = new JTextField();

      /* JcomboBox components */
      dateDayAddCredit_combo = new JComboBox<String>(dateDay);
      dateMonthAddCredit_combo = new JComboBox<String>(dateMonth);
      dateYearAddCredit_combo = new JComboBox<String>(dateYear);

      dateDayWithdraw_combo = new JComboBox<String>(dateDay);
      dateMonthWithdraw_combo = new JComboBox<String>(dateMonth);
      dateYearWithdraw_combo = new JComboBox<String>(dateYear);

      /*setBounds for components*/

      // JLabel
      mainScreenWelcome_label.setBounds(250, 169, 490, 35);
      mainScreenInstruction_label.setBounds(250, 208, 337, 25);

      welcomeUserAddDebit_label.setBounds(100, 100, 500, 35);
      issuerBankAddDebit_label.setBounds(118, 175, 120, 25);
      bankAccountAddDebit_label.setBounds(118, 255, 120, 25);
      cardIdAddDebit_label.setBounds(118, 335, 120, 25);
      balanceAddDebit_label.setBounds(118, 415, 120, 25);
      pinNumberAddDebit_label.setBounds(118, 495, 120, 25);

      welcomeUserAddCredit_label.setBounds(100, 100, 500, 35);
      issuerBankAddCredit_label.setBounds(118, 175, 120, 25);
      bankAccountAddCredit_label.setBounds(118, 255, 120, 25);
      cardIdAddCredit_label.setBounds(118, 335, 120, 25);
      balanceAddCredit_label.setBounds(118, 415, 120, 25);
      cvcNumberAddCredit_label.setBounds(118, 495, 120, 25);
      interestAddCredit_label.setBounds(450, 175, 113, 25);
      withdrawalAmount_label.setBounds(118, 302, 242, 35);
      dayAddCredit_label.setBounds(442, 280, 42, 25);
      monthAddCredit_label.setBounds(424, 326, 60, 25);
      yearAddCredit_label.setBounds(438, 372, 46, 25);

      welcomeUserWithdraw_label.setBounds(100, 100, 392, 35);
      balanceWithdraw_label.setBounds(100, 135, 392, 35);
      cardIdWithdraw_label.setBounds(118, 200, 72, 25);
      pinNumberWithdraw_label.setBounds(118, 355, 104, 25);
      withdrawalAmount_label.setBounds(118, 277, 160, 25);
      dayWithdraw_label.setBounds(438, 225, 42, 25);
      monthWithdraw_label.setBounds(420, 271, 60, 25);
      yearWithdraw_label.setBounds(434, 317, 46, 25);

      welcomeUserCheckBalance_label.setBounds(50, 45, 280, 35);
      currentBalanceCheckBalance_label.setBounds(50, 110, 312, 35);

      welcomeUserSetCredit_label.setBounds(100, 100, 500, 35);
      cardIdSetCredit_label.setBounds(118, 175, 120, 25);
      creditLimitSetCredit_label.setBounds(118, 255, 120, 25);
      gracePeriodSetCredit_label.setBounds(118, 335, 120, 25);

      welcomeUserCancelCredit_label.setBounds(50, 25, 310, 35);
      cardIdCancelCredit_label.setBounds(50, 80, 72, 25);

      // TextField
      clientNameMainScreen_textField.setBounds(250, 250, 242, 34);

      issuerBankAddDebit_textField.setBounds(118, 200, 242, 35);
      bankAccountAddDebit_textField.setBounds(118, 280, 242, 35);
      cardIdAddDebit_textField.setBounds(118, 360, 242, 35);
      balanceAddDebit_textField.setBounds(118, 440, 242, 35);
      pinNumberAddDebit_textFiled.setBounds(118, 520, 242, 35);

      issuerBankAddCredit_textField.setBounds(118, 200, 242, 35);
      bankAccountAddCredit_textField.setBounds(118, 280, 242, 35);
      cardIdAddCredit_textField.setBounds(118, 360, 242, 35);
      balanceAddCredit_textField.setBounds(118, 440, 242, 35);
      cvcNumberAddCredit_textFiled.setBounds(118, 520, 242, 35);
      interestAddCredit_textField.setBounds(450, 200, 145, 35);

      cardIdWithdraw_textField.setBounds(118, 225, 242, 35);
      withdrawalAmount_textField.setBounds(118, 302, 242, 35);
      pinNumberWithdraw_textField.setBounds(118, 380, 242, 35);

      cardIdSetCredit_textField.setBounds(118, 200, 242, 35);
      creditLimit_textField.setBounds(118, 280, 242, 35);
      gracePeriod_textField.setBounds(118, 360, 242, 35);
      
      cardIdCancelCredit_textField.setBounds(50, 105, 242, 35);

      // Button
      addClientNameMainScreen_button.setBounds(250, 300, 202, 40);
      changeClientNameMainScreen_button.setBounds(250, 300, 202, 40);
      checkBalanceMainScreen_button.setBounds(250, 360, 202, 40);
      addDebitCardMainScreen_button.setBounds(790, 100, 202, 40);
      addCreditCardMainScreen_button.setBounds(790, 171, 202, 40);
      setCreditMainScreen_button.setBounds(790, 242, 202, 40);
      debitCardInfoMainScreen_button.setBounds(790, 313, 202, 40);
      creditCardInfoMainScreen_button.setBounds(790, 384, 202, 40);
      withdrawMainScreen_button.setBounds(790, 455, 202, 40);
      cancelCreditMainScreen_button.setBounds(790, 526, 202, 40);

      addDebitCard_button.setBounds(794, 255, 202, 40);
      clearAddDebit_button.setBounds(794, 316, 202, 40);
      exitAddDebit_button.setBounds(794, 377, 202, 40);

      addCreditCard_button.setBounds(794, 255, 202, 40);
      clearAddCredit_button.setBounds(794, 316, 202, 40);
      exitAddCredit_button.setBounds(794, 377, 202, 40);

      withdraw_button.setBounds(794, 255, 202, 40);
      clearWithdraw_button.setBounds(794, 316, 202, 40);
      exitWithdraw_button.setBounds(794, 377, 202, 40);

      setCredit_button.setBounds(794, 255, 202, 40);
      clearSetCredit_button.setBounds(794, 316, 202, 40);
      exitSetCredit_button.setBounds(794, 377, 202, 40);

      cancelCredit_button.setBounds(50, 155, 202, 40);

      // Combobox
      dateDayAddCredit_combo.setBounds(490, 280, 105, 34);
      dateMonthAddCredit_combo.setBounds(490, 326, 105, 34);
      dateYearAddCredit_combo.setBounds(490, 372, 105, 34);

      dateDayWithdraw_combo.setBounds(486, 225, 105, 35);
      dateMonthWithdraw_combo.setBounds(486, 271, 105, 35);
      dateYearWithdraw_combo.setBounds(486, 317, 105, 35);

      // Setting visibility of buttons/components false by default
      changeClientNameMainScreen_button.setVisible(false);

      /* Add components to JPanel */
      mainScreen_panel.add(mainScreenWelcome_label);
      mainScreen_panel.add(mainScreenInstruction_label);
      mainScreen_panel.add(addClientNameMainScreen_button);
      mainScreen_panel.add(changeClientNameMainScreen_button);
      mainScreen_panel.add(clientNameMainScreen_textField);
      mainScreen_panel.add(addDebitCardMainScreen_button);
      mainScreen_panel.add(addCreditCardMainScreen_button);
      mainScreen_panel.add(setCreditMainScreen_button);
      mainScreen_panel.add(checkBalanceMainScreen_button);
      mainScreen_panel.add(debitCardInfoMainScreen_button);
      mainScreen_panel.add(creditCardInfoMainScreen_button);
      mainScreen_panel.add(withdrawMainScreen_button);
      mainScreen_panel.add(cancelCreditMainScreen_button);

      addDebitCard_panel.add(welcomeUserAddDebit_label);
      addDebitCard_panel.add(issuerBankAddDebit_label);
      addDebitCard_panel.add(bankAccountAddDebit_label);
      addDebitCard_panel.add(cardIdAddDebit_label);
      addDebitCard_panel.add(balanceAddDebit_label);
      addDebitCard_panel.add(pinNumberAddDebit_label);
      addDebitCard_panel.add(issuerBankAddDebit_textField);
      addDebitCard_panel.add(bankAccountAddDebit_textField);
      addDebitCard_panel.add(cardIdAddDebit_textField);
      addDebitCard_panel.add(balanceAddDebit_textField);
      addDebitCard_panel.add(pinNumberAddDebit_textFiled);
      addDebitCard_panel.add(addDebitCard_button);
      addDebitCard_panel.add(clearAddDebit_button);
      addDebitCard_panel.add(exitAddDebit_button);

      addCreditCard_panel.add(addCreditCard_button);
      addCreditCard_panel.add(clearAddCredit_button);
      addCreditCard_panel.add(exitAddCredit_button);
      addCreditCard_panel.add(welcomeUserAddCredit_label);
      addCreditCard_panel.add(issuerBankAddCredit_label);
      addCreditCard_panel.add(bankAccountAddCredit_label);
      addCreditCard_panel.add(cardIdAddCredit_label);
      addCreditCard_panel.add(balanceAddCredit_label);
      addCreditCard_panel.add(cvcNumberAddCredit_label);
      addCreditCard_panel.add(interestAddCredit_label);
      addCreditCard_panel.add(dayAddCredit_label);
      addCreditCard_panel.add(monthAddCredit_label);
      addCreditCard_panel.add(yearAddCredit_label);
      addCreditCard_panel.add(issuerBankAddCredit_textField);
      addCreditCard_panel.add(bankAccountAddCredit_textField);
      addCreditCard_panel.add(cardIdAddCredit_textField);
      addCreditCard_panel.add(balanceAddCredit_textField);
      addCreditCard_panel.add(cvcNumberAddCredit_textFiled);
      addCreditCard_panel.add(interestAddCredit_textField);
      addCreditCard_panel.add(dateDayAddCredit_combo);
      addCreditCard_panel.add(dateMonthAddCredit_combo);
      addCreditCard_panel.add(dateYearAddCredit_combo);

      withdraw_panel.add(welcomeUserWithdraw_label);
      withdraw_panel.add(balanceWithdraw_label);
      withdraw_panel.add(cardIdWithdraw_label);
      withdraw_panel.add(withdrawalAmount_label);
      withdraw_panel.add(pinNumberWithdraw_label);
      withdraw_panel.add(dayWithdraw_label);
      withdraw_panel.add(monthWithdraw_label);
      withdraw_panel.add(yearWithdraw_label);
      withdraw_panel.add(cardIdWithdraw_textField);
      withdraw_panel.add(withdrawalAmount_textField);
      withdraw_panel.add(pinNumberWithdraw_textField);
      withdraw_panel.add(withdraw_button);
      withdraw_panel.add(clearWithdraw_button);
      withdraw_panel.add(exitWithdraw_button);
      withdraw_panel.add(dateDayWithdraw_combo);
      withdraw_panel.add(dateMonthWithdraw_combo);
      withdraw_panel.add(dateYearWithdraw_combo);

      setCredit_panel.add(setCredit_button);
      setCredit_panel.add(clearSetCredit_button);
      setCredit_panel.add(exitSetCredit_button);
      setCredit_panel.add(welcomeUserSetCredit_label);
      setCredit_panel.add(cardIdSetCredit_label);
      setCredit_panel.add(creditLimitSetCredit_label);
      setCredit_panel.add(gracePeriodSetCredit_label);
      setCredit_panel.add(cardIdSetCredit_textField);
      setCredit_panel.add(creditLimit_textField);
      setCredit_panel.add(gracePeriod_textField);

      checkBalance_frame.add(welcomeUserCheckBalance_label);
      checkBalance_frame.add(currentBalanceCheckBalance_label);

      cancelCredit_frame.add(welcomeUserCancelCredit_label);
      cancelCredit_frame.add(cardIdCancelCredit_label);
      cancelCredit_frame.add(cardIdCancelCredit_textField);
      cancelCredit_frame.add(cancelCredit_button);

      /* set layout of jpanel */
      mainScreen_panel.setLayout(null);
      mainScreen_panel.setSize(1200, 672);
      mainScreen_panel.setVisible(true);

      // Debit Card Panel
      addDebitCard_panel.setLayout(null);
      addDebitCard_panel.setSize(1200, 672);
      addDebitCard_panel.setVisible(false);

      // Credit Card Panel
      addCreditCard_panel.setLayout(null);
      addCreditCard_panel.setSize(1200, 672);
      addCreditCard_panel.setVisible(false);

      // set credit panel
      setCredit_panel.setLayout(null);
      setCredit_panel.setSize(1200, 672);
      setCredit_panel.setVisible(false);

      // Withdraw Panel
      withdraw_panel.setLayout(null);
      withdraw_panel.setSize(1200, 672);
      withdraw_panel.setVisible(false);

      /* Add JPanel to JFrame */
      mainJFrame.add(mainScreen_panel);
      mainJFrame.add(addDebitCard_panel);
      mainJFrame.add(addCreditCard_panel);
      mainJFrame.add(setCredit_panel);
      mainJFrame.add(withdraw_panel);
      mainJFrame.add(setCredit_panel);

      // JFrame methods        
      mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // making sure the JFrame is fully closed instead of just being not visible   
      mainJFrame.setLayout(null); //removing the default layout 
      mainJFrame.setSize(1200, 672); //setting the width and height of the JFrame
      mainJFrame.setLocationRelativeTo(null); // to make sure the frame appears from the middle  
      mainJFrame.setResizable(false);  
      mainJFrame.setVisible(true); //setting the visibility of mainFrame

      checkBalance_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      checkBalance_frame.setLayout(null); //removing the default layout 
      checkBalance_frame.setSize(390, 220); //setting the width and height of the JFrame
      checkBalance_frame.setLocationRelativeTo(null); // to make sure the frame appears from the middle   
      checkBalance_frame.setResizable(false);  
      checkBalance_frame.setVisible(false); //setting the visibility of mainFrame
        
      cancelCredit_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      cancelCredit_frame.setLayout(null);
      cancelCredit_frame.setSize(400, 300);
      cancelCredit_frame.setLocationRelativeTo(null);
      cancelCredit_frame.setResizable(false);
      cancelCredit_frame.setVisible(false);
    }

    // Overriding the abstract method from action event listener class
    @Override
    public void actionPerformed(ActionEvent e) {
      String clientName = clientNameMainScreen_textField.getText(); //setting the client name for instance variable

      // TO add client name
      if(e.getSource() == addClientNameMainScreen_button) {
        if(clientName.isEmpty()) {
          JOptionPane.showMessageDialog(mainJFrame, "Client Name Cannot be Empty", "Alert", JOptionPane.ERROR_MESSAGE, sad_icon);
        } else {
          mainScreenWelcome_label.setText("Welcome " + clientName + ","); //Change client name of welcome screen
          welcomeUserAddDebit_label.setText("User: " + clientName); //Change client name of Debit Card Screen
          welcomeUserAddCredit_label.setText("User: " + clientName); //Change client name of Credit card screen
          welcomeUserCheckBalance_label.setText("User: " + clientName); // change client name for check balance
          welcomeUserSetCredit_label.setText("User: " + clientName); // change client name for set credit limit
          welcomeUserCancelCredit_label.setText("User: " + clientName); // change client name for cancel credit
          addClientNameMainScreen_button.setVisible(false);
          mainScreenInstruction_label.setVisible(false);
          clientNameMainScreen_textField.setVisible(false);
          changeClientNameMainScreen_button.setVisible(true);
        }

        // TO change client name
      } else if(e.getSource()== changeClientNameMainScreen_button) {
        mainScreenWelcome_label.setText("Welcome User,");
        addClientNameMainScreen_button.setVisible(true);
        mainScreenInstruction_label.setVisible(true); 
        clientNameMainScreen_textField.setVisible(true);
        changeClientNameMainScreen_button.setVisible(false);
        clientNameMainScreen_textField.setText("");
        clientName = "";

        // Go to add debit card screen
      } else if(e.getSource() == addDebitCardMainScreen_button ) {
        if(clientName.isEmpty()) {
          JOptionPane.showMessageDialog(mainJFrame, "Client Name Cannot be Empty", "Alert", JOptionPane.ERROR_MESSAGE, sad_icon);
        } else {
          mainScreen_panel.setVisible(false);
          addDebitCard_panel.setVisible(true);
        }

        // go to add credit card screen
      } else if (e.getSource() == addCreditCardMainScreen_button) {
        if(clientName.isEmpty()) {
          JOptionPane.showMessageDialog(mainJFrame, "Client Name Cannot be Empty", "Alert", JOptionPane.ERROR_MESSAGE, sad_icon);
        } else {
          mainScreen_panel.setVisible(false);
          addCreditCard_panel.setVisible(true);
        }

        // go to set credit limit panel
      } else if(e.getSource() == setCreditMainScreen_button) {
        Boolean creditExists = false;
        
        if(clientName.isEmpty()) {
          JOptionPane.showMessageDialog(mainJFrame, "Client Name Cannot be Empty", "Alert", JOptionPane.ERROR_MESSAGE, sad_icon);
        } else {
          for(BankCard bankCard_obj : bankCard_ArrayList) {
            if(bankCard_obj instanceof CreditCard) {
              creditExists = true;
            }
          }

          if(creditExists) {
            mainScreen_panel.setVisible(false);
            setCredit_panel.setVisible(true);
          } else {
            JOptionPane.showMessageDialog(mainJFrame, "Please add a Credit card", "Card not found", JOptionPane.ERROR_MESSAGE, stopHand_icon);           
          }
        }

          // show current balance
      }else if (e.getSource() == checkBalanceMainScreen_button) {
        Boolean debitExists = false;
        
        if(clientName.isEmpty()) {
          JOptionPane.showMessageDialog(mainJFrame, "Client Name Cannot be Empty", "Alert", JOptionPane.ERROR_MESSAGE, sad_icon);
        } else {
          for(BankCard bankCard_obj : bankCard_ArrayList) {
            if(bankCard_obj instanceof DebitCard) {
              DebitCard debitCard_obj = (DebitCard) bankCard_obj;
              currentBalanceCheckBalance_label.setText("Balance: Rs." + String.valueOf(debitCard_obj.get_balance()));
              debitExists = true;
            }
          }
          
          if(!debitExists) {
            JOptionPane.showMessageDialog(mainJFrame, "Debit Card does not exist", "Card not Fount", JOptionPane.ERROR_MESSAGE, sad_icon);
          } else {
            checkBalance_frame.setVisible(true);
          }
        }

        // show debit card information
      } else if (e.getSource() == debitCardInfoMainScreen_button) {
        Boolean debitExists = false;
        
        if(clientName.isEmpty()) {
          JOptionPane.showMessageDialog(mainJFrame, "Client Name Cannot be Empty", "Alert", JOptionPane.ERROR_MESSAGE, sad_icon);
        } else {
          for(BankCard bankcard_obj : bankCard_ArrayList) {
            if(bankcard_obj instanceof DebitCard) {
              DebitCard debitCard_obj = (DebitCard) bankcard_obj;
              debitCard_obj.display();
              debitExists = true;
            }
          }

          if(!debitExists) {
            JOptionPane.showMessageDialog(mainJFrame, "Please add a debit card", "No card found", JOptionPane.ERROR_MESSAGE, sad_icon);
          }  
        }

        // show credit card information
      } else if (e.getSource() == creditCardInfoMainScreen_button) {
        Boolean creditExists = false;
        
        if(clientName.isEmpty()) {
          JOptionPane.showMessageDialog(mainJFrame, "Client Name Cannot be Empty", "Alert", JOptionPane.ERROR_MESSAGE, sad_icon);
        } else {
          for(BankCard bankcard_obj : bankCard_ArrayList) {
            if(bankcard_obj instanceof CreditCard) {
              CreditCard creditCard_obj = (CreditCard) bankcard_obj;
              creditCard_obj.display();
              creditExists = true;
            }
          }

          if(!creditExists) {
            JOptionPane.showMessageDialog(mainJFrame, "Please add a credit ard", "No card found", JOptionPane.ERROR_MESSAGE, sad_icon);
          } 
        }

        // go to withdraw screen
      } else if (e.getSource() == withdrawMainScreen_button) {
        Boolean debitExists = false;
          
        if(clientName.isEmpty()) {
          JOptionPane.showMessageDialog(mainJFrame, "Client Name Cannot be Empty", "Alert", JOptionPane.ERROR_MESSAGE, sad_icon);
        } else {
          for(BankCard bankCard_obj : bankCard_ArrayList) {
            if(bankCard_obj instanceof DebitCard) {
              DebitCard debitCard_obj = (DebitCard) bankCard_obj;
              balanceWithdraw_label.setText("Balance Rs." + String.valueOf(debitCard_obj.get_balance()));
              debitExists = true;
            }
          }

          if(debitExists) {
            mainScreen_panel.setVisible(false);
            withdraw_panel.setVisible(true);
          } else {
            JOptionPane.showMessageDialog(mainJFrame, "Please add a debit card", "Card not found", JOptionPane.ERROR_MESSAGE, stopHand_icon);           
          }
        }
        
        // go back to main screen from add debit
      } else if(e.getSource() == exitAddDebit_button) {
        addDebitCard_panel.setVisible(false);
        mainScreen_panel.setVisible(true);

        // clear values in add debit
      } else if(e.getSource() == clearAddDebit_button) {
        issuerBankAddDebit_textField.setText("");
        bankAccountAddDebit_textField.setText("");
        cardIdAddDebit_textField.setText("");
        balanceAddDebit_textField.setText("");
        pinNumberAddDebit_textFiled.setText("");
        JOptionPane.showMessageDialog(mainJFrame, "All fields cleared", "cleared", JOptionPane.INFORMATION_MESSAGE, clear_icon); 

        // go back to main screen from add credit
      } else if(e.getSource() == exitAddCredit_button) {
        addCreditCard_panel.setVisible(false);
        mainScreen_panel.setVisible(true);

        // clear values in add credit
      } else if(e.getSource() == clearAddCredit_button) {
        issuerBankAddDebit_textField.setText("");
        bankAccountAddDebit_textField.setText("");
        cardIdAddDebit_textField.setText("");
        balanceAddDebit_textField.setText("");
        cvcNumberAddCredit_textFiled.setText("");
        interestAddCredit_textField.setText("");
        JOptionPane.showMessageDialog(mainJFrame, "All fields cleared", "cleared", JOptionPane.INFORMATION_MESSAGE, clear_icon); 

        // go back to main screen 
      } else if(e.getSource() == exitSetCredit_button) {
        setCredit_panel.setVisible(false);
        mainScreen_panel.setVisible(true);

      } else if(e.getSource() == clearSetCredit_button) {
        cardIdSetCredit_textField.setText("");
        creditLimit_textField.setText("");
        gracePeriod_textField.setText("");
        JOptionPane.showMessageDialog(mainJFrame, "All fields cleared", "cleared", JOptionPane.INFORMATION_MESSAGE, clear_icon); 
      
        // go back to main screen from exit withdraw
      }else if(e.getSource() == exitWithdraw_button) {
        withdraw_panel.setVisible(false);
        mainScreen_panel.setVisible(true);

        // clear values in withdraw
      } else if(e.getSource() == clearWithdraw_button) {
        cardIdWithdraw_textField.setText("");
        withdrawalAmount_textField.setText("");
        pinNumberWithdraw_textField.setText("");
        JOptionPane.showMessageDialog(mainJFrame, "All fields cleared", "cleared", JOptionPane.INFORMATION_MESSAGE, clear_icon); 

        // add a new debit card object
      } else if(e.getSource() == addDebitCard_button) {
        try {
          // getting the required items from the gui

          String issuerBank = issuerBankAddDebit_textField.getText();
          String bankAccount = bankAccountAddDebit_textField.getText();
          int cardId = Integer.parseInt(cardIdAddDebit_textField.getText());
          int balanceAmount = Integer.parseInt(balanceAddDebit_textField.getText());
          int pinNumber = Integer.parseInt(pinNumberAddDebit_textFiled.getText());
          Boolean debitExists = false;

          if(issuerBank.isEmpty() || clientName.isEmpty() || bankAccount.isEmpty()) {
            JOptionPane.showMessageDialog(mainJFrame, "Empty Field Detected", "Error", JOptionPane.ERROR_MESSAGE, sad_icon);

          } else {
            // For Each loop to iterate through bankCard array list to check for instance of debit card
            for(BankCard bankCard_obj : bankCard_ArrayList) {
              if(bankCard_obj instanceof DebitCard && bankCard_obj.get_cardID() == cardId) {
                JOptionPane.showMessageDialog(mainJFrame, "The card you are trying to add already exists", "Warning", JOptionPane.WARNING_MESSAGE, stopHand_icon);
                debitExists = true;
                break;
              }
            }
            
            if(!debitExists) {
              DebitCard debitCard_obj = new DebitCard(clientName, issuerBank, bankAccount, cardId, balanceAmount, pinNumber); // create a new debitcard object
              bankCard_ArrayList.add(debitCard_obj); // add the object to bank card array list
              JOptionPane.showMessageDialog(mainJFrame, "Debit card added successfully", "Success", JOptionPane.INFORMATION_MESSAGE, happy_icon); // show success message
              addDebitCard_panel.setVisible(false);
              mainScreen_panel.setVisible(true);
              debitExists = true;
            }
          }  

        } catch(NumberFormatException numFormat_ex) {
          JOptionPane.showMessageDialog(mainJFrame, "Card ID, Balance Amount or Pin Number Invalid", "Error", JOptionPane.ERROR_MESSAGE, sad_icon);
        } 

        // withdraw money from card 
      } else if(e.getSource() == withdraw_button) {
        try {
          int cardId = Integer.parseInt(cardIdWithdraw_textField.getText());
          int withdrawalAmount = Integer.parseInt(withdrawalAmount_textField.getText());
          int pinNumber = Integer.parseInt(pinNumberWithdraw_textField.getText());

          String dateDay = dateDayWithdraw_combo.getSelectedItem().toString();
          String dateMonth = dateMonthWithdraw_combo.getSelectedItem().toString();
          String dateYear = dateYearWithdraw_combo.getSelectedItem().toString();
          String date = dateDay + "/" + dateMonth + "/" + dateYear; // Converting the date into a string
          

          DebitCard debitCard_obj = null;
          for(BankCard bankCard_obj : bankCard_ArrayList) {
            if(bankCard_obj instanceof DebitCard && bankCard_obj.get_cardID() == cardId) {
              debitCard_obj = (DebitCard) bankCard_obj;
            }
          }

          if(debitCard_obj != null) {
            if(pinNumber == debitCard_obj.get_pinNumber() && withdrawalAmount <= debitCard_obj.get_balance()) {
              debitCard_obj.withdraw(pinNumber, withdrawalAmount, date);
              JOptionPane.showMessageDialog(mainJFrame, "User: " + clientName + "\n" + "Amount: Rs." + String.valueOf(withdrawalAmount) + "\n" + date, "Successfully withdrawn", JOptionPane.INFORMATION_MESSAGE, happy_icon);
              withdraw_panel.setVisible(false);
              mainScreen_panel.setVisible(true);
            } else {
              JOptionPane.showMessageDialog(mainJFrame, "Please check your PIN and Balance", "Transaction unsuccessful", JOptionPane.ERROR_MESSAGE, sad_icon);
            }
          } else {
            JOptionPane.showMessageDialog(mainJFrame, "Please add a debit card", "Card not found", JOptionPane.ERROR_MESSAGE, stopHand_icon);
          }

        } catch(NumberFormatException ex) {
          JOptionPane.showMessageDialog(mainJFrame, "Card ID, Withdrawal Amount or Pin Number Invalid", "Error", JOptionPane.ERROR_MESSAGE, sad_icon);
        }

        // to cancel credit card
      } else if(e.getSource() == cancelCreditMainScreen_button) {
        if(clientName.isEmpty()) {
          JOptionPane.showMessageDialog(mainJFrame, "Client Name Cannot be Empty", "Alert", JOptionPane.ERROR_MESSAGE, sad_icon);
        } else {
          cancelCredit_frame.setVisible(true);
        }
        
        // add a new credit card
      }else if(e.getSource() == addCreditCard_button) {
        try {
          String issuerBank = issuerBankAddCredit_textField.getText();
          String bankAccount = bankAccountAddCredit_textField.getText();
          int cardId = Integer.parseInt(cardIdAddCredit_textField.getText());
          int balanceAmount = Integer.parseInt(balanceAddCredit_textField.getText());
          int cvcNumber = Integer.parseInt(cvcNumberAddCredit_textFiled.getText());
          Double interestRate = Double.parseDouble(interestAddCredit_textField.getText());

          String dateDay = dateDayAddCredit_combo.getSelectedItem().toString();
          String dateMonth = dateMonthAddCredit_combo.getSelectedItem().toString();
          String dateYear = dateYearAddCredit_combo.getSelectedItem().toString();
          String date = dateDay + "/" + dateMonth + "/" + dateYear; // Converting the date into a string
          Boolean creditExists = false;
          
          if(issuerBank.isEmpty() || bankAccount.isEmpty()) {
            JOptionPane.showMessageDialog(mainJFrame, "Please check Issuer Bank or Bank Account", "Invalid Input", JOptionPane.ERROR_MESSAGE, sad_icon);
          } else {
            for(BankCard bankCard_obj : bankCard_ArrayList) {
              if(bankCard_obj instanceof CreditCard && bankCard_obj.get_cardID() == cardId) {
                JOptionPane.showMessageDialog(mainJFrame, "Card already exists", "Error", JOptionPane.ERROR_MESSAGE, stopHand_icon);
                creditExists = true;
                break;
              } 
            }

            if(!creditExists) {
              CreditCard creditCard_obj = new CreditCard(clientName, issuerBank, bankAccount, cardId, balanceAmount, cvcNumber, interestRate, date);
              bankCard_ArrayList.add(creditCard_obj);
              JOptionPane.showMessageDialog(mainJFrame, "Credit card added successfully", "Success", JOptionPane.INFORMATION_MESSAGE, happy_icon); // show success message
              addCreditCard_panel.setVisible(false);
              mainScreen_panel.setVisible(true);
              creditExists = true;
            }
          }

        } catch(NumberFormatException ex) {
          JOptionPane.showMessageDialog(mainJFrame, "Please check your Card ID, Balance or CVC number", "Invalid Input", JOptionPane.ERROR_MESSAGE, sad_icon);
        }

      } else if(e.getSource() == setCredit_button) {
        Boolean creditIsGranted = false;

        try {
          int cardId = Integer.parseInt(cardIdSetCredit_textField.getText());
          int creditLimit = Integer.parseInt(creditLimit_textField.getText());
          int gracePeriod = Integer.parseInt(gracePeriod_textField.getText());

          for(BankCard bankCard_obj : bankCard_ArrayList) {
            if(bankCard_obj instanceof CreditCard && bankCard_obj.get_cardID() == cardId) {
              CreditCard creditCard_obj = (CreditCard) bankCard_obj;
              creditCard_obj.setCreditLimit(creditLimit, gracePeriod);
              creditIsGranted = true;
            }
          }

          if(!creditIsGranted) {
            JOptionPane.showMessageDialog(mainJFrame, "Please check you Card Id", "Card not found", JOptionPane.ERROR_MESSAGE, sad_icon);
          } else {
            JOptionPane.showMessageDialog(mainJFrame, "Credit limit set successfully", "Success", JOptionPane.INFORMATION_MESSAGE, happy_icon);
            setCredit_panel.setVisible(false);
            mainScreen_panel.setVisible(true);
          }

        } catch(NumberFormatException ex) {
          JOptionPane.showMessageDialog(mainJFrame, "Please check your values", "Invalid Input", JOptionPane.ERROR_MESSAGE, sad_icon);
        }

      } else if(e.getSource() == cancelCredit_button) {
        try {
          int cardId = Integer.parseInt(cardIdCancelCredit_textField.getText());

          CreditCard creditCard_obj = null;
          for(BankCard bankCard_obj : bankCard_ArrayList) {
            if(bankCard_obj instanceof CreditCard && bankCard_obj.get_cardID() == cardId) {
              creditCard_obj = (CreditCard) bankCard_obj;
              break;
            }
          }

          if(creditCard_obj != null) {
            creditCard_obj.cancelCreditCard();
            JOptionPane.showMessageDialog(mainJFrame, "Credit card Cancelled successfully", "Success", JOptionPane.INFORMATION_MESSAGE, happy_icon);
            cancelCredit_frame.dispose();
          } else {
            JOptionPane.showMessageDialog(mainJFrame, "Please check you Card Id", "Card not found", JOptionPane.ERROR_MESSAGE, sad_icon);
          }
        } catch(NumberFormatException ex) {
          JOptionPane.showMessageDialog(mainJFrame, "Please check you Card Id", "Invalid Card ID", JOptionPane.ERROR_MESSAGE, sad_icon);
        }

      }

    }

    public static void main (String[] Args) {
      new BankGUI();
    }
}
