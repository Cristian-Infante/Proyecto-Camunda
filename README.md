# Validación para comprobar si la solicitud de crédito está incompleta

`${(RUT == null) || (historialCrediticio == null) || (esEmpleado == "true" && certificadoLaboral == null) || (esIndependiente == "true" && declaracionImpuestos == null) || (esPensionado == "true" && comprobantePagoPension == null)}`


Se verifica si la solicitud de crédito está incompleta si:
1. El historial crediticio es nulo.
2. El RUT es nulo.
3. Es empleado y no proporciona un certificado laboral.
4. Es independiente y no proporciona una declaración de impuestos.
5. Es pensionado y no proporciona un comprobante de pago de pensión.


# Tabla de decisión para validación de créditos

| Regla | Edad  | Es empleado | Certificado laboral | Es independiente | Declaración de impuestos | Es pensionado | Comprobante pago pensión | Historial crediticio | Validación |
|:-----:|:-----:|:-----------:|:-------------------:|:----------------:|:------------------------:|:-------------:|:------------------------:|:--------------------:|:----------:|
|   1   |  <22  | any([true]) |     any([true])     |   any([true])    |       any([true])        |  any([true])  |       any([true])        |     any([true])      |   false    |
|   2   | 22-75 |    true     |     "Reciente"      |      false       |       "No aplica"        |     false     |       "No aplica"        |    "Alto","Medio"    |    true    |
|   3   | 22-75 |    true     |     "Reciente"      |      false       |       "No aplica"        |     false     |       "No aplica"        |        "Bajo"        |   false    |
|   4   | 22-75 |    true     |      "Vencido"      |      false       |       "No aplica"        |     false     |       "No aplica"        |     any([true])      |   false    |
|   5   | 22-75 |    false    |     "No aplica"     |       true       |       "Presentada"       |     false     |       "No aplica"        |    "Alto","Medio"    |    true    |
|   6   | 22-75 |    false    |     "No aplica"     |       true       |       "Presentada"       |     false     |       "No aplica"        |        "Bajo"        |   false    |
|   7   | 22-75 |    false    |     "No aplica"     |       true       |        "Vencido"         |     false     |       "No aplica"        |     any([true])      |   false    |
|   8   |  >75  |    false    |     "No aplica"     |      false       |       "No aplica"        |     true      |        "Reciente"        |        "Alto"        |    true    |
|   9   |  >75  |    false    |     "No aplica"     |      false       |       "No aplica"        |     true      |        "Reciente"        |    "Medio","Bajo"    |   false    |
|  10   |  >75  |    false    |     "No aplica"     |      false       |       "No aplica"        |     true      |        "Vencido"         |     any([true])      |   false    |

En esta tabla de reglas se asumen:
1. La edad del solicitante es un factor importante en la decisión de validar o no la solicitud de crédito. No se consideran solicitudes de menores de 22 años.
2. Los empleados deben proporcionar un certificado laboral Reciente para verificar su estabilidad laboral, y su historial crediticio debe ser medio o alto para ser considerados para la validación. En caso de que el certificado laboral esté vencido, la solicitud no será validada.
3. Los independientes deben presentar una declaración de impuestos reciente para ser considerados para la validación. Su historial crediticio debe ser medio o alto para ser considerados para la validación. En caso de que la declaración de impuestos esté vencida, la solicitud no será validada.
4. Los pensionados deben presentar un comprobante de pago de pensión reciente para ser considerados para la validación. Su historial crediticio debe ser alto para ser considerados para la validación. En caso de que el comprobante de pago de pensión esté vencido, la solicitud no será validada.

