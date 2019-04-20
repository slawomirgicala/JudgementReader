import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppGUI {

    private JudgmentQueries queries;

    private JFrame frame;

    private JTextField rubrumTextField;
    private JButton getRubrum;

    private JTextField contentTextField;
    private JButton getContent;

    private JTextField judgeTextField;
    private JButton getJudge;

    private final Dimension dimension = new Dimension(400,10);

    public AppGUI(JudgmentQueries queries){
        this.queries = queries;
    }



    public void buildGUI(){
        frame = new JFrame("Judgments");

        rubrumTextField = new JTextField();
        rubrumTextField.setPreferredSize(dimension);
        getRubrum = new JButton("RUBRUM");
        getRubrum.addActionListener(new MyRubrumListener());

        contentTextField = new JTextField();
        contentTextField.setPreferredSize(dimension);
        getContent = new JButton("CONTENT");
        getContent.addActionListener(new MyContentListener());


        judgeTextField = new JTextField();
        judgeTextField.setPreferredSize(dimension);
        getJudge = new JButton("JUDGE");
        getJudge.addActionListener(new MyJudgeListener());

        JButton topJudges = new JButton("TOP JUDGES");
        topJudges.addActionListener(new MyTopJudgesListener());

        JButton months = new JButton("JUDGMENTS BY MONTHS");
        months.addActionListener(new MyMonthsListener());

        JButton courts = new JButton("JUDGMENTS BY COURTS");
        courts.addActionListener(new MyCourtsListener());

        JButton regulations = new JButton("POPULAR REGULATIONS");
        regulations.addActionListener(new MyRegulationsListener());

        JButton jury = new JButton("JURY QUANTITY");
        jury.addActionListener(new MyJuryListener());

        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.PAGE_AXIS));

        //JPanel panel = new JPanel();
        //panel.setBorder(new LineBorder(Color.BLACK));
        //frame.add(panel,new GridBagConstraints());

        frame.getContentPane().add(rubrumTextField);
        frame.getContentPane().add(getRubrum);
        frame.getContentPane().add(contentTextField);
        frame.getContentPane().add(getContent);
        frame.getContentPane().add(judgeTextField);
        frame.getContentPane().add(getJudge);
        frame.getContentPane().add(topJudges);
        frame.getContentPane().add(months);
        frame.getContentPane().add(courts);
        frame.getContentPane().add(regulations);
        frame.getContentPane().add(jury);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.setVisible(true);
    }


    public class MyRubrumListener implements ActionListener{

        public void actionPerformed(ActionEvent a){
            if (!rubrumTextField.getText().equals("")){
                String signatures = rubrumTextField.getText();
                rubrumTextField.setText("");
                String[] signaturesArr = signatures.split(",");
                showDialog(queries.getSentences(signaturesArr));
            }
        }
    }

    public class MyContentListener implements ActionListener{

        public void actionPerformed(ActionEvent a){
            if (!contentTextField.getText().equals("")){
                String signature = contentTextField.getText();
                contentTextField.setText("");
                showDialog(queries.getReason(signature));
            }
        }
    }

    public class MyJudgeListener implements ActionListener{

        public void actionPerformed(ActionEvent a){
            if (!judgeTextField.getText().equals("")){
                String judge = judgeTextField.getText();
                judgeTextField.setText("");
                showDialog(Integer.toString(queries.getNumberOfSentences(judge)));
            }
        }
    }

    public class MyTopJudgesListener implements ActionListener{

        public void actionPerformed(ActionEvent a){
            showDialog(queries.getTop10());
        }
    }


    public class MyMonthsListener implements ActionListener{

        public void actionPerformed(ActionEvent a){
            showDialog(queries.sentencesByMonth());
        }
    }

    public class MyCourtsListener implements ActionListener{

        public void actionPerformed(ActionEvent a){
            showDialog(queries.sentencesByCourt());
        }
    }

    public class MyRegulationsListener implements ActionListener{

        public void actionPerformed(ActionEvent a){
            showDialog(queries.popularRegulations());
        }
    }

    public class MyJuryListener implements ActionListener{

        public void actionPerformed(ActionEvent a){
            showDialog(queries.numberOfJudges());
        }
    }


    private void showDialog(String text){
        JDialog dialog = new JDialog(frame,"");
        JTextArea textArea = new JTextArea();
        textArea.append(text);
        textArea.setSize(300,300);
        dialog.setSize(400,400);
        dialog.add(textArea);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

}
