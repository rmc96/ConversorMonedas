package conversorMonedas;

public class FunctionMonedas {
	
    public String ConvertirMonedas(double valor, String opcionSelected) {
    	String resultado ="";
        if (opcionSelected == "De Soles a Dólar") {
        	System.out.println(opcionSelected);
        	double monedaDolar = valor / 3.65;
    		monedaDolar = (double) Math.round(monedaDolar *100d)/100;
    		resultado = "Tienes $ " +monedaDolar+ " Dolares";
//        	return valor;
        }
        else if (opcionSelected == "De Soles a Euro") {
        	System.out.println(opcionSelected);
        	double monedaDolar = valor / 4.04;
    		monedaDolar = (double) Math.round(monedaDolar *100d)/100;
    		resultado = "Tienes € " +monedaDolar+ " Euros";
			
		}
        else if (opcionSelected == "De Soles a Libras Esterlinas") {
        	System.out.println(opcionSelected);
        	double monedaDolar = valor / 4.67;
    		monedaDolar = (double) Math.round(monedaDolar *100d)/100;
    		resultado = "Tienes £ " +monedaDolar+ " Libras Esterlinas";
			
		}
        else if (opcionSelected == "De Soles a Yen") {
        	System.out.println(opcionSelected);
        	double monedaDolar = valor / 0.026;
    		monedaDolar = (double) Math.round(monedaDolar *100d)/100;
    		resultado = "Tienes ¥ " +monedaDolar+ " Yenes";
			
		}
        else if (opcionSelected == "De Soles a Won Coreano") {
        	System.out.println(opcionSelected);
        	double monedaDolar = valor / 0.0028;
    		monedaDolar = (double) Math.round(monedaDolar *100d)/100;
    		resultado = "Tienes ₩ " +monedaDolar+ " Wones";
			
		}
        else if (opcionSelected == "De Dólar a Soles") {
        	System.out.println(opcionSelected);
        	double monedaDolar = valor * 3.65;
    		monedaDolar = (double) Math.round(monedaDolar *100d)/100;
    		resultado = "Tienes S/ " +monedaDolar+ " Soles";
			
		}
        else if (opcionSelected == "De Euro a Soles") {
        	System.out.println(opcionSelected);
        	double monedaDolar = valor * 4.04;
    		monedaDolar = (double) Math.round(monedaDolar *100d)/100;
    		resultado = "Tienes S/ " +monedaDolar+ " Soles";
			
		}
        else if (opcionSelected == "De Libras Esterlinas a Soles") {
        	System.out.println(opcionSelected);
        	double monedaDolar = valor * 4.67;
    		monedaDolar = (double) Math.round(monedaDolar *100d)/100;
    		resultado = "Tienes S/ " +monedaDolar+ " Soles";
			
		}
        else if (opcionSelected == "De Yen a Soles") {
        	System.out.println(opcionSelected);
        	double monedaDolar = valor * 0.026;
    		monedaDolar = (double) Math.round(monedaDolar *100d)/100;
    		resultado = "Tienes S/ " +monedaDolar+ " Soles";
			
		}
        else if (opcionSelected == "De Won Coreano a Soles") {
        	System.out.println(opcionSelected);
        	double monedaDolar = valor * 0.0028;
    		monedaDolar = (double) Math.round(monedaDolar *100d)/100;
    		resultado = "Tienes S/ " +monedaDolar+ " Soles";
			
		}
		return resultado;
        	
          
    }
}
