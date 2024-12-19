plugins {
    id("bergs.pwx.gradle.testes.mobile")
}

subprojects {
	apply(plugin = "bergs.pwx.gradle.testes.mobile")

    dependencies {
        implementation(files("\\\\corp.banrisul.com.br\\deptos\\TransfDigital\\Transformacao-Digital\\Chapter QA\\Codigo Fonte Framework\\Bmouaajm_teste_funcional_banrisul_digital-0.1.27.jar"))
        functionalTestImplementation(files("\\\\corp.banrisul.com.br\\deptos\\TransfDigital\\Transformacao-Digital\\Chapter QA\\Codigo Fonte Framework\\Bmouaajm_suporte_automacao-0.1.35.jar"))
        implementation("com.github.javafaker:javafaker:1.0.2")
        implementation("org.reflections:reflections:0.10.2")
    }
    
}
