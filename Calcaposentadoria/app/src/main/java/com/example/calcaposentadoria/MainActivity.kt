package com.example.calcaposentadoria


import android.app.Activity
import android.os.Bundle
import android.widget.*



class MainActivity: Activity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        //Definir o arquivo de layout
        setContentView(R.layout.activity_main)
        //acessando 0spinner
        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)
        // acessando a caixa de idade
        val idadetxt = findViewById<EditText>(R.id.txt_idade)
        //acessando button
        val btncalcular = findViewById<Button>(R.id.btn_calcular)
        //acessando resultado
        val resultadotxt = findViewById<TextView>(R.id.resultado)
        val tempotrab = findViewById<EditText>(R.id.respostatempotrab)
            ArrayAdapter.createFromResource(this, R.array.opcoessexo, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spn_sexo.adapter = adapter }
        btncalcular.setOnClickListener(){
            val sexo = spn_sexo.selectedItem as String
            val idade = idadetxt.text.toString().toInt()
            val tempo = tempotrab.text.toString().toInt()
            if(sexo == "Masculino"){
                if(idade>= 65 && tempo>=15) {
                    resultadotxt.text = ("Você pode se aposentar.")
                }else{
                    if(idade>=65 &&  tempo<15){
                        val resulttempo = 15 - tempo
                        resultadotxt.text = ("Você tem a idade certa, porém falta $resulttempo anos trabalhos.")
                    }else{
                        if(idade<65 && tempo>=15){
                            val anos = 65 - idade
                            resultadotxt.text = ("Você contribuiu por tempo suficiente, porém ainda não possui a idade certa, faltam $anos anos para completar 65.")
                        }else{
                            val resulttempo = 15 - tempo
                            val anos = 65 - idade
                            resultadotxt.text = ("Faltam $resulttempo anos de contribuição e $anos anos de idade, para conseguir se aposentar")
                        }
                    }
                }
                }
                // sexo feminino
                else {
                if(idade>= 60 && tempo>=15) {
                    resultadotxt.text = ("Você pode se aposentar.")
                }else{
                    if(idade>=60 &&  tempo<15){
                        val resulttempo = 15 - tempo
                        resultadotxt.text = ("Você tem a idade certa, porém falta $resulttempo anos trabalhos.")
                    }else{
                        if(idade<60 && tempo>=15){
                            val anos = 60 - idade
                            resultadotxt.text = ("Você contribuiu por tempo suficiente, porém ainda não possui a idade certa, faltam $anos anos para completar 60.")
                        }else{
                            val resulttempo = 15 - tempo
                            val anos = 60 - idade
                            resultadotxt.text = ("Faltam $resulttempo anos de contribuição e $anos anos de idade, para conseguir se aposentar")
                        }
                    }
                }
            }

                }
    }
}

