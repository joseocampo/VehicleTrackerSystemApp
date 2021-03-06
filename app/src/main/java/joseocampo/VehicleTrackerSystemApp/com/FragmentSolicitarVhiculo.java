package joseocampo.VehicleTrackerSystemApp.com;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentSolicitarVhiculo.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentSolicitarVhiculo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSolicitarVhiculo extends Fragment
 implements   Response.Listener<JSONObject>, Response.ErrorListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    //este es un comentario de prueba para hacer commit.
    private EditText campoDestino,campoJustificacion;
    private Button btnRealizarSolicitd;

    private Spinner lista;
    private String[] vehiculos = {"Vehiculos disponibles","Nissan","Toyota","Nissan Versa","Susuki","Chevrolet","Huydani"};

    private OnFragmentInteractionListener mListener;

    public FragmentSolicitarVhiculo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentSolicitarVhiculo.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSolicitarVhiculo newInstance(String param1, String param2) {
        FragmentSolicitarVhiculo fragment = new FragmentSolicitarVhiculo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_fragment_solicitar_vhiculo, container, false);

        lista = (Spinner) vista.findViewById(R.id.listaVehiculos);
        campoDestino = (EditText)vista.findViewById(R.id.campoDestino);
        campoJustificacion = (EditText)vista.findViewById(R.id.campoJustificacion);
        btnRealizarSolicitd = (Button)vista.findViewById(R.id.btnRealizarSolicitud);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item,vehiculos);
        lista.setAdapter(adaptador);
        btnRealizarSolicitd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarWebService();
            }
        });

        return vista;
    }
    private void cargarWebService() {
        Toast.makeText(getContext(),"Esperando que Tony se conecte a la bd",Toast.LENGTH_LONG).show();

    }
    @Override
    public void onResponse(JSONObject response) {

    }
    @Override
    public void onErrorResponse(VolleyError error) {

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }




    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
