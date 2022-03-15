#include <iostream>

using namespace std;

int main()
{
    // VAR
    int N, i, restaHoras;  // N = casos de prueba
    bool suspende;
    
    struct {
        
        int asignaturas;
        int horas;
        int notas[10000];
        
    } datosAlumno;
    
    
    
    // CONST
    const char APRUEBA[] = "APRUEBA TODO";
    const char JUNIO[]   = "NOS VEMOS EN JUNIO...";
    
    
    // PROGRAMA
    
    cin >> N; 
    
    while (not N == 0) {
        cin >> datosAlumno.asignaturas;
        cin >> datosAlumno.horas;
        for (i = 0; i <  datosAlumno.asignaturas; i = i + 1) {
            cin >> datosAlumno.notas[i];
        }
        
        i = 0;
        suspende = false;  // Reinicializamos variables
        
        while ((i < datosAlumno.asignaturas) and (not suspende)) {
            if (datosAlumno.notas[i] < 50) {
               restaHoras = 50 - datosAlumno.notas[i];
               datosAlumno.horas = datosAlumno.horas - restaHoras;
               suspende = (datosAlumno.horas <= 0) and (i < datosAlumno.asignaturas);
            }
            ++i;
			else {
		    ++i;
	        }
        }
        if (suspende) {
            cout << JUNIO << std::endl;
        }
        else {
            cout << APRUEBA << std::endl;
        }
    --N;
    }
    
    return 0;
}