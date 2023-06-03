package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoTipoRelacionInstitucionAssembler;
import co.edu.uco.publiuco.business.business.EstadoTipoRelacionInstitucionBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoTipoRelacionInstitucionBusinessImpl;
import co.edu.uco.publiuco.business.domain.EstadoTipoRelacionInstitucionDomain;
import co.edu.uco.publiuco.business.facade.EstadoTipoRelacionInstitucionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoTipoRelacionInstitucionFacadeImplMessage;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoTipoRelacionInstitucionDTO;

public final class EstadoTipoRelacionInstitucionFacadeImpl implements EstadoTipoRelacionInstitucionFacade {

	private final DAOFactory daoFactory;
	private final EstadoTipoRelacionInstitucionBusiness business;

	public EstadoTipoRelacionInstitucionFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new EstadoTipoRelacionInstitucionBusinessImpl(daoFactory);
	}

	@Override
	public void register(EstadoTipoRelacionInstitucionDTO dto) {
		try {
			daoFactory.initTransaction();
			final EstadoTipoRelacionInstitucionDomain domain = EstadoTipoRelacionInstitucionAssembler.getInstance()
					.toDomainFromDTO(dto);

			business.register(domain);
			daoFactory.commitTransaction();
		} catch (final PubliUcoException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelarTransaccion();


			throw PubliUcoBusinessException.create(EstadoTipoRelacionInstitucionFacadeImplMessage.REGISTER_EXCEPTION_TECHNICAL_MESSAGE_STRING,  EstadoTipoRelacionInstitucionFacadeImplMessage.REGISTER_EXCEPTION_USER_MESSAGE_STRING, exception);
		} finally {
			daoFactory.cerrarConexion();
		}

	}

	@Override
	public List<EstadoTipoRelacionInstitucionDTO> list(EstadoTipoRelacionInstitucionDTO dto) {
		try {
			final var domain = EstadoTipoRelacionInstitucionAssembler.getInstance().toDomainFromDTO(dto);
			final var returnDomainList = business.list(domain);

			final List<EstadoTipoRelacionInstitucionDomain> domainList = returnDomainList;
			return EstadoTipoRelacionInstitucionAssembler.getInstance().toDTOListFromDomainList(domainList);
		} catch (final PubliUcoException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelarTransaccion();

			throw PubliUcoBusinessException.create(
					EstadoTipoRelacionInstitucionFacadeImplMessage.REGISTER_EXCEPTION_TECHNICAL_MESSAGE_STRING,
					EstadoTipoRelacionInstitucionFacadeImplMessage.REGISTER_EXCEPTION_USER_MESSAGE_STRING, exception);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modify(EstadoTipoRelacionInstitucionDTO dto) {
		try {
			daoFactory.initTransaction();
			final EstadoTipoRelacionInstitucionDomain domain = EstadoTipoRelacionInstitucionAssembler.getInstance()
					.toDomainFromDTO(dto);

			business.modify(domain);
			daoFactory.commitTransaction();
		} catch (final PubliUcoException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelarTransaccion();


			throw PubliUcoBusinessException.create(EstadoTipoRelacionInstitucionFacadeImplMessage.REGISTER_EXCEPTION_TECHNICAL_MESSAGE_STRING, EstadoTipoRelacionInstitucionFacadeImplMessage.REGISTER_EXCEPTION_USER_MESSAGE_STRING, exception);
		} finally {
			daoFactory.cerrarConexion();
		}

	}

	@Override
	public void drop(EstadoTipoRelacionInstitucionDTO dto) {
		try {
			daoFactory.initTransaction();
			final EstadoTipoRelacionInstitucionDomain domain = EstadoTipoRelacionInstitucionAssembler.getInstance()
					.toDomainFromDTO(dto);

			business.drop(domain);
			daoFactory.commitTransaction();
		} catch (final PubliUcoException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.cancelarTransaccion();

		
			throw PubliUcoBusinessException.create(
					EstadoTipoRelacionInstitucionFacadeImplMessage.REGISTER_EXCEPTION_TECHNICAL_MESSAGE_STRING,
					EstadoTipoRelacionInstitucionFacadeImplMessage.REGISTER_EXCEPTION_USER_MESSAGE_STRING, exception);
		} finally {
			daoFactory.cerrarConexion();
		}

	}

}
