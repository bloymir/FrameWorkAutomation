Feature: El objetivo es validar que la configuracion del framework funcione
    
    @SmokeTest
    Scenario Outline: Scenario Outline name: Realizo una navegacion por google con la finalidad de probar el framework
    Given navego a www.freerangetester.com
    When hago clic en la seccion <section>
    And hago clic en ver mas, del curso introduccion al testing


    Examples:
        | section | 
        | Cursos |

    @SandboxTest
    Scenario Outline: Realizo la navegacion a Sandbox page de FreeRangerTester
        Given navego a www.freerangetester.com
        When hago clic en la seccion <section>
        And hago clic en el link de sandbox

        Examples:
            | section |
            | Recursos |

    @MembreciaTest
    Scenario: Los usuarios pueden un plan de pago en la academia
        Given navego a www.freerangetester.com
        When hago clic en el boton Elegir Plan