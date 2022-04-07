export const Data = () => {
  const OpTiempo = [
    {
      id: 1,
      name: 'Rapido',
    },
    {
      id: 2,
      name: 'Medio',
    },
    {
      id: 3,
      name: 'Normal',
    },
    {
      id: 4,
      name: 'Lento',
    },
  ];
  const OpComidaCalidad = [
    {
      id: 1,
      name: 'Exquisita',
    },
    {
      id: 2,
      name: 'Buena',
    },
    {
      id: 3,
      name: 'Normal',
    },
    {
      id: 4,
      name: 'Mala',
    },
  ];
  const OpCalidadRestaurant = [
    {
      id: 1,
      name: '5 estrellas',
    },
    {
      id: 2,
      name: '4 estrellas',
    },
    {
      id: 3,
      name: '3 estrellas',
    },
    {
      id: 4,
      name: '2 o ménos estrellas',
    },
  ];

  const OpCantidadComida = [
    {
      id: 1,
      name: 'Mochoso',
    },
    {
      id: 2,
      name: 'Light',
    },
    {
      id: 3,
      name: 'Gurmet',
    },
    {
      id: 4,
      name: 'Normal',
    },
  ];

  return [OpTiempo, OpComidaCalidad, OpCalidadRestaurant, OpCantidadComida];
};
