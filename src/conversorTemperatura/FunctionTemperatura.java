package conversorTemperatura;


public class FunctionTemperatura {
	
    public String ConvertirTemperatura(double valor, String opcionSelected) {
    	
    	String resultado ="";
        if (opcionSelected == "Grados Celcius a Grados Farenheit") {
        	double farenheit =  ConvertirCelciusAFarenheit(valor);           
    		resultado = valor + " Grados Celcius son " +farenheit+ " Grados Farenheit ";
//        	return valor;
        }
        else if (opcionSelected == "Grados Celcius a Kelvin") {
        	double kelvin = valor + 273.15;
            kelvin = (double) Math.round(kelvin *100d)/100;
    		resultado = valor+ " Grados Celcius son " +kelvin+ " Kelvin";
			
		}
        else if (opcionSelected == "Grados Farenheit a Grados Celcius") {
        	double celcius = (valor - 32) / 1.8;
            celcius = (double) Math.round(celcius *100d)/100;
    		resultado = valor+ " Grados Farenheit son " +celcius+ " Celcius";
			
		}
        else if (opcionSelected == "Kelvin a Grados Celcius") {
        	double kelvinCelcius = ConvertirKelvinACelcius(valor);
    		resultado = valor+ " Kelvin son " +kelvinCelcius+ " Celcius";
			
		}
        else if (opcionSelected == "Kelvin a Grados Farenheit") {
        	double kelvinFarenheit = ConvertirKelvinACelcius(valor);
    		kelvinFarenheit = ConvertirCelciusAFarenheit(kelvinFarenheit);
    		kelvinFarenheit	= (double) Math.round(kelvinFarenheit *100d)/100;
    		resultado = valor+ " Kelvin son " +kelvinFarenheit+ " Celcius";
			
		}
		return resultado;
        	
          
    }
    public double ConvertirCelciusAFarenheit(double valor) {
		double farenheit = valor * 1.8 + 32;
    	farenheit = (double) Math.round(farenheit *100d)/100;
		return farenheit;
	}
    public double ConvertirKelvinACelcius(double valor) {
		 double kelvinCelcius = valor - 273.15;
        kelvinCelcius = (double) Math.round(kelvinCelcius *100d)/100;
        return kelvinCelcius;
	}
}
