package pablo.tzeliks.infrastructure.persistence;

import pablo.tzeliks.application.dto.CustomerRequestDTO;
import pablo.tzeliks.domain.repository.CustomerRepository;
import pablo.tzeliks.infrastructure.connection.ConnectDatabase;

import java.sql.*;

public class CostumerRepositoryImpl implements CustomerRepository {

    private final ConnectDatabase connectDatabase;

    public CostumerRepositoryImpl(ConnectDatabase connectDatabase) {
        this.connectDatabase = connectDatabase;
    }

    @Override
    public CustomerRequestDTO save(CustomerRequestDTO customer) {
        String sql = "INSERT INTO customers (name, cpf, cnpj, street_address, street_number, neighborhood, zip_code, address_complement, city_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connectDatabase.connect();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, customer.name());
            ps.setString(2, customer.documentNumber()); // Validar CPF ou CNPJ
            ps.setString(3, customer.getCnpj() != null ? customer.getCnpj().getValor() : null);
            ps.setString(4, customer.getAddress().getStreetAddress());
            ps.setString(5, customer.getAddress().getStreetNumber());
            ps.setString(6, customer.getAddress().getNeighborhood());
            ps.setString(7, customer.getAddress().getZipCode());
            ps.setString(8, customer.getAddress().getAddressComplement());
            ps.setLong(9, customer.getAddress().getCityId());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    customer.setId(rs.getLong(1));
                }
            }
            return customer;

        } catch (SQLException e) {
            throw new InfrastructureException("Erro ao salvar cliente", e);
        }
    }

    @Override
    public Optional<Customer> findById(Long id) {
        String sql = "SELECT * FROM customers WHERE id = ?";
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(CustomerMapper.toEntity(rs));
                }
            }
        } catch (SQLException e) {
            throw new InfrastructureException("Erro ao buscar cliente por ID", e);
        }
        return Optional.empty();
    }
    // ... Implementar os outros métodos (update, deleteById, findByDocument, findAll)
}
