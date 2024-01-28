package br.com.decorafacil.infra.inmemory

import br.com.decorafacil.models.Address
import br.com.decorafacil.models.Client
import br.com.decorafacil.models.Event
import br.com.decorafacil.models.Payment
import br.com.decorafacil.repository.EventRepository
import java.math.BigDecimal

class EventRepositoryInMemory : EventRepository {

    override fun findEventsWithPendingPayments(): List<Event> {
        return listOf(
            Event(Client("Pedro Henrique Pereira"), Payment(BigDecimal("1150")), Address("Rua Governador da Silva", "Jd. das Flores", "Itapetininga", "São Paulo", "77", "45669890")),
            Event(Client("Maria Oliveira Santos"), Payment(BigDecimal("800")), Address("Avenida Brasil", "Centro", "Cidade Alegre", "Rio de Janeiro", "123", "12345678")),
            Event(Client("Lucas Silva"), Payment(BigDecimal("1200")), Address("Rua da Paz", "Bela Vista", "Cidade Tranquila", "Minas Gerais", "45", "78901234")),
            Event(Client("Ana Souza Oliveira"), Payment(BigDecimal("950")), Address("Rua Principal", "Vila Feliz", "Cidade Felicidade", "Bahia", "20", "56789012")),
            Event(Client("Fernanda Santos"), Payment(BigDecimal("1300")), Address("Rua da Amizade", "América", "Cidade Amiga", "Santa Catarina", "10", "34567890")),
            Event(Client("Rafael Oliveira"), Payment(BigDecimal("1100")), Address("Avenida Central", "Jardim Botânico", "Cidade das Flores", "Paraná", "56", "67890123")),
            Event(Client("Amanda Lima"), Payment(BigDecimal("1000")), Address("Rua da Liberdade", "Liberdade", "Cidade Livre", "São Paulo", "30", "89012345")),
            Event(Client("Carlos Santos"), Payment(BigDecimal("900")), Address("Avenida da Esperança", "Esperança", "Cidade Esperançosa", "Rio Grande do Sul", "15", "01234567")),
            Event(Client("Larissa Costa"), Payment(BigDecimal("850")), Address("Rua do Sol", "Sol Nascente", "Cidade do Sol", "Ceará", "25", "23456789")),
            Event(Client("Rodrigo Silva Costa"), Payment(BigDecimal("950")), Address("Avenida da Juventude", "Jovem", "Cidade Jovial", "Pernambuco", "18", "45678901")),
            Event(Client("Camila Souza"), Payment(BigDecimal("1200")), Address("Rua dos Sonhos", "Sonho Real", "Cidade dos Sonhos", "Goiás", "22", "56789012")),
            Event(Client("José Oliveira Lima"), Payment(BigDecimal("1100")), Address("Avenida da Saudade", "Saudade", "Cidade Saudosa", "Paraíba", "29", "67890123")),
            Event(Client("Fernando Lima"), Payment(BigDecimal("1300")), Address("Rua da Alegria", "Alegre", "Cidade Alegria", "Maranhão", "33", "78901234")),
            Event(Client("Bianca Santos"), Payment(BigDecimal("1000")), Address("Avenida da Harmonia", "Harmonia", "Cidade Harmoniosa", "Amazonas", "27", "89012345")),
            Event(Client("Gabriel Costa"), Payment(BigDecimal("800")), Address("Rua da Tranquilidade", "Tranquilidade", "Cidade Tranquila", "Tocantins", "14", "01234567")),
            Event(Client("Mariana Oliveira"), Payment(BigDecimal("900")), Address("Avenida da Liberdade", "Liberdade", "Cidade Livre", "Alagoas", "36", "23456789")),
            Event(Client("Ricardo Silva Souza"), Payment(BigDecimal("1100")), Address("Rua do Progresso", "Progresso", "Cidade Progressista", "Acre", "42", "45678901")),
            Event(Client("Isabela Souza"), Payment(BigDecimal("950")), Address("Avenida da Prosperidade", "Prosperidade", "Cidade Próspera", "Sergipe", "21", "56789012")),
            Event(Client("Vinícius Lima Souza"), Payment(BigDecimal("1200")), Address("Rua da Felicidade", "Felicidade", "Cidade Feliz", "Rondônia", "39", "67890123")),
            Event(Client("Juliana Souza Santos"), Payment(BigDecimal("1000")), Address("Avenida do Amor", "Amor", "Cidade do Amor", "Amapá", "48", "78901234"))
        )
    }

}