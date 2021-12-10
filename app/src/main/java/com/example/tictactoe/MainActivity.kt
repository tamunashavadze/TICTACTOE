class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var Button1: Button
    private lateinit var Button2: Button
    private lateinit var Button3: Button
    private lateinit var Button4: Button
    private lateinit var Button5: Button
    private lateinit var Button6: Button
    private lateinit var Button7: Button
    private lateinit var Button8: Button
    private lateinit var Button9: Button
    private lateinit var reset: Button
    private lateinit var player1: TextView
    private lateinit var player2: TextView

    private var firstPlayerPoint = 0
    private var secondPlayerPoint = 0


    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    private var activePlayer = 1

    private fun init() {
        Button1 = findViewById(R.id.Button1)
        Button2 = findViewById(R.id.Button2)
        Button3 = findViewById(R.id.Button3)
        Button4 = findViewById(R.id.Button4)
        Button5 = findViewById(R.id.Button5)
        Button6 = findViewById(R.id.Button6)
        Button7 = findViewById(R.id.Button7)
        Button8 = findViewById(R.id.Button8)
        Button9 = findViewById(R.id.Button9)
        reset = findViewById(R.id.reset)
        player1 = findViewById(R.id.player1)
        player2 = findViewById(R.id.player2)

        Button1.setOnClickListener(this)
        Button2.setOnClickListener(this)
        Button3.setOnClickListener(this)
        Button4.setOnClickListener(this)
        Button5.setOnClickListener(this)
        Button6.setOnClickListener(this)
        Button7.setOnClickListener(this)
        Button8.setOnClickListener(this)
        Button9.setOnClickListener(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        reset.setOnClickListener{
            activePlayer = 1
            firstPlayer.clear()
            secondPlayer.clear()
            for (ButtonNumber in 1..9) {
                val clickedView:Button = when(ButtonNumber){
                    1->Button1
                    2->Button2
                    3->Button3
                    4->Button4
                    5->Button5
                    6->Button6
                    7->Button7
                    8->Button8
                    9->Button9
                    else ->{Button1}
                }
                clickedView.text=""
                clickedView.setBackgroundColor(Color.BLUE)
                clickedView.isEnabled = true

            }
        }

    }
    private fun halt() {

        Button1.isEnabled = false
        Button2.isEnabled = false
        Button3.isEnabled = false
        Button4.isEnabled = false
        Button5.isEnabled = false
        Button6.isEnabled = false
        Button7.isEnabled = false
        Button8.isEnabled = false
        Button9.isEnabled = false

    }


    private fun point() {

        player1.text = "Player 1: $firstPlayerPoint"
        player2.text = "Player 2: $secondPlayerPoint"
    }


    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {
            var ButtonNumber = 0
            when (clickedView.id) {
                R.id.Button1 -> ButtonNumber = 1
                R.id.Button2 -> ButtonNumber = 2
                R.id.Button3 -> ButtonNumber = 3
                R.id.Button4 -> ButtonNumber = 4
                R.id.Button5 -> ButtonNumber = 5
                R.id.Button6 -> ButtonNumber = 6
                R.id.Button7 -> ButtonNumber = 7
                R.id.Button8 -> ButtonNumber = 8
                R.id.Button9 -> ButtonNumber = 9

            }
            if (ButtonNumber != 0) {
                playGame(clickedView, ButtonNumber)
            }
        }

    }


    private fun playGame(clickedView: Button, ButtonNumber: Int) {
        if (activePlayer == 1) {
            clickedView.text = "x"
            clickedView.setBackgroundColor(Color.GREEN)
            activePlayer = 2
            firstPlayer.add(ButtonNumber)
        } else {
            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.RED)
            activePlayer = 1
            secondPlayer.add(ButtonNumber)
        }
        clickedView.isEnabled = false
        check()


    }

    private fun check() {
        var winnerPlayer = 0
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }

        if (winnerPlayer == 1) {
            Toast.makeText(this, "X is winner", Toast.LENGTH_SHORT).show()
            firstPlayerPoint += 1
            point()
            halt()
        }

        if (winnerPlayer == 2) {
            Toast.makeText(this, "O is winner", Toast.LENGTH_SHORT).show()
            secondPlayerPoint += 1
            point()
            halt()

        }

    }

}


