import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by keillera on 14/04/30.
 */
public class DiceForm extends JFrame {
    private JButton execButton;
    private JLabel leftDiceLabel;
    private JLabel rightDiceLabel;
    private JPanel dicePanel;
    private JLabel resultLabel;
    private JRadioButton sixSidedDiceOneRadioButton;
    private JRadioButton sixSidedDiceTwoRadioButton;
    private JRadioButton twentySidedDiceRadioButton;

    public DiceForm() {
        super("Dice 0.0.1");
        super.setSize(640, 280);

        ButtonGroup group = new ButtonGroup();
        group.add(sixSidedDiceOneRadioButton);
        group.add(sixSidedDiceTwoRadioButton);
        group.add(twentySidedDiceRadioButton);
        setContentPane(dicePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        execButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer leftNum = getRandomIntFromOne(getCurrentNum());
                Integer rightNum = 0;
                if(useRightDice()) {
                    rightNum = getRandomIntFromOne(getCurrentNum());
                }
                Integer resultNum = leftNum + rightNum;
                leftDiceLabel.setText(leftNum.toString());
                rightDiceLabel.setText(rightNum.toString());
                resultLabel.setText(resultNum.toString());
            }
        });
        setVisible(true);
    }

    private Integer getRandomIntFromOne(Integer num) {
        Random rnd = new Random();
        return rnd.nextInt(num) + 1;
    }

    private Integer getCurrentNum() {
        if(twentySidedDiceRadioButton.isSelected()) {
            return 20;
        }
        return 6;
    }
    private Boolean useRightDice() {
        if(sixSidedDiceTwoRadioButton.isSelected()){
            return true;
        }
        return false;
    }
}
