package util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by maurolcsilva on 30/11/2017.
 */

/**Esta Classe foi construída seguindo o padrão de projeto Singleton
 * Forçara a existência de termos dentro do sistema uma única referência
 * que representa o Banco de Dados (atributo db).
 * De outra forma teríamos espalhado pelo Sistema várias referências a este atributo.
 */

public class DBGateway {
    private static DBGateway gw;
    private SQLiteDatabase db;

    public DBGateway(Context ctx){
        CriaBD criabd = new CriaBD(ctx);
        this.db = criabd.getWritableDatabase();
    }

    public static DBGateway getInstance(Context ctx){
        //"Pulo do Gato"
        //Verificamos se já existe uma referência a gw (DBGateway)
        //Se não existir criamos ela, através do construtor
        //Neste momento é criada a referência a db
        //Tenha atençao que este método é estático e pode ser chamado
        //Sem a existência de uma referência a DBGateway
        if (gw == null)
            gw = new DBGateway(ctx);
        return gw;
    }

    public SQLiteDatabase getDatabase(){
        return this.db;
    }
}
