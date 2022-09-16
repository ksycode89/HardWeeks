package co.micol.prj.member.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.micol.prj.common.DAO;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;

public class MemberServiceImpl implements MemberService  {
	
	private DAO dao =new DAO();
	private PreparedStatement pstm;
	private ResultSet rs;

	@Override
	public List<MemberVO> memberSelectList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO mv;
		String sql = "SELECT * FROM MEMBER";

		try {

			pstm = dao.conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				mv = new MemberVO();
				mv.setMemberId(rs.getString("member_id"));
				mv.setMemberName(rs.getString("member_name"));
				mv.setMemberPassword(rs.getString("Member_Password"));
				mv.setMemberTel(rs.getString("member_tel"));
				mv.setMemberAuthor(rs.getString("Member_Author"));
				list.add(mv);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		MemberVO mv =null;
		System.out.println("memverimpl= "+vo.getMemberId());
		try {
			String sql = "SELECT * FROM MEMBER WHERE member_id= ?";
			pstm = dao.conn.prepareStatement(sql);
			pstm.setString(1, vo.getMemberId());
			rs = pstm.executeQuery();
			System.out.println(pstm);
			
			
			while (rs.next()) {
				mv = new MemberVO();
				mv.setMemberId(rs.getString("member_id"));
				mv.setMemberName(rs.getString("member_name"));
				mv.setMemberPassword(rs.getString("Member_Password"));
				mv.setMemberTel(rs.getString("member_tel"));
				mv.setMemberAuthor(rs.getString("Member_Author"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return mv;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		int result = 0;
		System.out.println(vo);
		try {
			String sql = "INSERT INTO member VALUES (?,?,?,?,?)";
			pstm = dao.conn.prepareStatement(sql);
			pstm.setString(1, vo.getMemberId());
			pstm.setString(2,vo.getMemberPassword());
			pstm.setString(3,vo.getMemberName());
			pstm.setString(4, vo.getMemberTel());
			pstm.setString(5, vo.getMemberAuthor());
			result = pstm.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {  
			disconnect();
		}
		
		return result;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		int result = 0;
		try {
			String sql = "DELETE FROM MEMBER WHERE MEMBER_ID = ?)";
			pstm.setString(1, vo.getMemberId());

			pstm = dao.conn.prepareStatement(sql);
			result = pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return result;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		int result = 0;
		try {
			String sql = "UPDATA MEMBER SET Member_Password=?,member_name=?,member_tel=?, "
					+ " Member_Author=? WHERE MEMBER_ID = ?";
			pstm.setString(1, vo.getMemberPassword());
			pstm.setString(2, vo.getMemberName());
			pstm.setString(3, vo.getMemberTel());
			pstm.setString(4, vo.getMemberAuthor());
			pstm.setString(5, vo.getMemberId());

			pstm = dao.conn.prepareStatement(sql);

			result = pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return result;
	}

	@Override
	public boolean isMemberId(String id) {
		boolean check = true;
		try {
			String sql = "SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_ID = ?";
			pstm.setString(1, id);
			pstm = dao.conn.prepareStatement(sql);
			rs = pstm.executeQuery();
//			while (rs.next()) {
//				if (rs.getString("member_id").equals(id)) {
//					check = false;
//				}
//			}
			if(rs.next()) {
				check= false;
			}

		} catch (Exception e) {
				e.printStackTrace();
		}
		return check;
	}

	private void disconnect() {
		try {
			if (rs != null) {
				rs.close();
			}

			if (pstm != null) {
				pstm.close();
			}
			if (dao.conn != null) {
				dao.conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} // end of catch
	}
}
