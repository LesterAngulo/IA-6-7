import React, { useState, useEffect } from 'react';
import {
  FormControl,
  FormHelperText,
  InputLabel,
  MenuItem,
  Card,
  Grid,
  Button,
  Box,
  CardContent,
  CardHeader,
  Divider,
  Typography,
  Stack,
} from '@mui/material';
import { Selector } from './Selector';
import { Data } from './Data/data';
export const FormularioFuzzy = () => {
  const [OpTiempo, OpComidaCalidad, OpCalidadRestaurant, OpCantidadComida] =
    Data();
  const [values, setValues] = useState();

  const [resultado, setResultado] = useState('sin resultado');
  const [identificadores, setIdentificadores] = useState();
  const handleChange = (e) => {
    setValues({
      ...values,
      [e.target.name]: e.target.value,
    });
  };

  useEffect(() => {
    if (values !== undefined) {
      let ids = Object.values(values);
      if (ids.length === 4) {
        setIdentificadores(ids.toString());
      }
    }
  }, [values]);

  console.log(identificadores);
  const handleSearch = () => {
    switch (identificadores) {
      case '1,1,1,1':
        setResultado('Comida Mexicana');
        break;
      case '2,2,2,2':
        setResultado('Comida Vietnamita');
        break;
      case '3,3,3,3':
        setResultado('Comida Francesa');
        break;
      case '4,4,4,4':
        setResultado('Comida India');
        break;
      case '1,2,1,2':
        setResultado('Comida Coreana');
        break;
      case '1,3,2,1':
        setResultado('Comida China');
        break;
      case '4,4,3,4':
        setResultado('Comida Libanesa');
        break;
      case '2,2,1,3':
        setResultado('Comida Japonesa');
        break;
      case '2,3,2,4':
        setResultado('Comida Peruana');
        break;
      default:
        setResultado('Aun no tenemos recomendacion para estas opciones');
        break;
    }
  };

  return (
    <Box
      sx={{
        display: 'flex',
        justifyContent: 'center',
        p: 1,
        m: 1,
      }}
    >
      <Card sx={{ width: 500, height: 600, textAlign: 'center' }}>
        <CardHeader title='Entradas Logica Difusa' />
        <Divider />
        <CardContent>
          <Stack
            direction='column'
            justifyContent='center'
            alignItems='center'
            spacing={2}
          >
            <Selector
              data={OpTiempo}
              handleSelected={handleChange}
              label='Tiempo'
              Cid='name'
              propName='Tiempo'
              byID={true}
              Width={200}
            />
            <Selector
              data={OpComidaCalidad}
              handleSelected={handleChange}
              label='CalidadComida'
              Cid='name'
              propName='CalidadComida'
              byID={true}
              Width={200}
            />
            <Selector
              data={OpCalidadRestaurant}
              handleSelected={handleChange}
              label='CalidadRestaurant'
              Cid='name'
              propName='CalidadRestaurant'
              byID={true}
              Width={200}
            />
            <Selector
              data={OpCantidadComida}
              handleSelected={handleChange}
              label='CantidadComida'
              Cid='name'
              propName='CantidadComida'
              byID={true}
              Width={200}
            />
          </Stack>
          <br />
          <Divider />
          <br />
          <Stack
            direction='row'
            justifyContent='center'
            alignItems='center'
            spacing={2}
          >
            <Button variant='outlined' onClick={handleSearch}>
              Buscar
            </Button>
            <Button variant='outlined' onClick={handleSearch}>
              Limpiar
            </Button>
          </Stack>
          <Typography variant='button'>Salidas </Typography>
          <br /> <h3>Se recomienda: </h3>
          <Typography variant='overline'>{resultado} </Typography>
        </CardContent>
      </Card>
    </Box>
  );
};
